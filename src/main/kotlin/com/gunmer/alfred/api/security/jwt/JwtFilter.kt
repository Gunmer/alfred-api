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
        try {
            val jwtToken = getJwtToken(request)
            val authentication = jwtProvider.authenticate(jwtToken)
            SecurityContextHolder.getContext().authentication = authentication
        } catch (e: Exception) {
            log.error("Security error: ${e.localizedMessage}")
        }
        filterChain.doFilter(request, response)
    }

    private fun getJwtToken(request: HttpServletRequest): String {
        val authorizationHeader = request.getHeader(authorization) ?: throw Exception("Authorization header not found in ${request.method} ${request.requestURI}")
        return if (authorizationHeader.startsWith(bearer)) authorizationHeader.substring(bearer.length) else authorizationHeader
    }
}
