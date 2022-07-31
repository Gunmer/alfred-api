package com.gunmer.alfred.test

import org.springframework.security.test.context.support.WithSecurityContext

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@WithSecurityContext(factory = WithMockCustomUserSecurityContextFactory::class)
annotation class WithMockCustomUser(
    val id: String = "1",
    val name: String = "Cristiam",
    val familyName: String = "Sosa",
)
