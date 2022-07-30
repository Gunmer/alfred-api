package com.gunmer.alfred.api.security.jwt

import com.gunmer.alfred.api.security.jwt.provider.JwtProvider
import mu.KotlinLogging
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtFilter(
    private val jwtProvider: JwtProvider
) : OncePerRequestFilter() {

    private val log = KotlinLogging.logger {}
    private val bearer = "Bearer "
    private val authorization = "Authorization"

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val jwtToken = getJwtToken(request)
        jwtToken?.let {
            log.debug("security token found in ${request.method} ${request.requestURI}")
            val authentication = jwtProvider.authenticate(it)
            SecurityContextHolder.getContext().authentication = authentication
            log.debug("Authentication successfully with user ${authentication.credentials}")
        }
        filterChain.doFilter(request, response)
    }

    private fun getJwtToken(request: HttpServletRequest): String? {
        val authorizationHeader = request.getHeader(authorization)
        return authorizationHeader?.let {
            if (it.startsWith(bearer)) it.substring(bearer.length) else it
        }
    }
}
