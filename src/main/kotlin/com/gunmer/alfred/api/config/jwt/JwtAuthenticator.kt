package com.gunmer.alfred.api.config.jwt

import com.gunmer.alfred.domain.user.User
import org.springframework.security.authentication.AbstractAuthenticationToken

class JwtAuthenticator(
    private val user: User,
) : AbstractAuthenticationToken(null) {

    init {
        isAuthenticated = true
    }

    override fun getCredentials(): Any {
        return user.id
    }

    override fun getPrincipal(): Any {
        return user
    }
}
