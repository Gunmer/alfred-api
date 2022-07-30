package com.gunmer.alfred.test

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.springframework.test.context.ActiveProfiles

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Tag("FunctionalTest")
@Test
@ActiveProfiles("test")
annotation class FunctionalTest()
