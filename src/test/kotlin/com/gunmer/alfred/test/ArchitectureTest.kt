package com.gunmer.alfred.test

import org.junit.jupiter.api.Tag

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Tag("ArchitectureTest")
annotation class ArchitectureTest()
