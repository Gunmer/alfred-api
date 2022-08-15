package com.gunmer.alfred.test

import io.github.glytching.junit.extension.random.RandomBeansExtension
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Tag("UnitTest")
@ExtendWith(MockitoExtension::class)
@ExtendWith(RandomBeansExtension::class)
annotation class UnitTest()
