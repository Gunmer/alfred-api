package com.gunmer.alfred.api.security.jwt.provider

import com.gunmer.alfred.api.security.jwt.JwtAuthenticator
import com.gunmer.alfred.domain.user.usecases.GetUser
import mu.KotlinLogging
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtLocalProvider(
    private val getUser: GetUser
) : JwtProvider {
    private val log = KotlinLogging.logger {}

    override fun authenticate(jwtToken: String): Authentication {
        log.debug("Authenticate with JwtLocalProvider")
        val user = getUser(userId = jwtToken)
        return JwtAuthenticator(user)
    }
}
