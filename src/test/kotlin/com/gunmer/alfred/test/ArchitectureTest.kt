package com.gunmer.alfred.test

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@Tag("ArchitectureTest")
@Test
annotation class ArchitectureTest()
