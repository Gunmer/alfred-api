package com.gunmer.alfred.api.config.jwt.provider

import org.springframework.security.core.Authentication

interface JwtProvider {
    fun authenticate(jwtToken: String): Authentication
}
