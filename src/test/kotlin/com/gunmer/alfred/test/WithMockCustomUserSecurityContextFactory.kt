package com.gunmer.alfred.test

import com.gunmer.alfred.api.config.jwt.JwtAuthenticator
import com.gunmer.alfred.domain.user.User
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.test.context.support.WithSecurityContextFactory

class WithMockCustomUserSecurityContextFactory : WithSecurityContextFactory<WithMockCustomUser> {
    override fun createSecurityContext(annotation: WithMockCustomUser): SecurityContext {
        val securityContext = SecurityContextHolder.createEmptyContext()
        val user = User(
            id = annotation.id,
            name = annotation.name,
            familyName = annotation.familyName
        )
        securityContext.authentication = JwtAuthenticator(user)

        return securityContext
    }
}
