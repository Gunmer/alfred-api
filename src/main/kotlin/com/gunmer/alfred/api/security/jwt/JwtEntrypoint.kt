package com.gunmer.alfred.api.security.jwt

import mu.KotlinLogging
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtEntrypoint : AuthenticationEntryPoint {
    private val log = KotlinLogging.logger {}

    override fun commence(request: HttpServletRequest?, response: HttpServletResponse?, authException: AuthenticationException?) {
        log.debug("Unauthorized request!!!")
        response?.sendError(HttpServletResponse.SC_UNAUTHORIZED, "unauthorized")
    }
}
