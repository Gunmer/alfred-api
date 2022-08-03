package com.gunmer.alfred.test

import io.github.glytching.junit.extension.random.RandomBeansExtension
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Tag("FunctionalTest")
@ActiveProfiles("test")
@ExtendWith(SpringExtension::class)
@ExtendWith(RandomBeansExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
annotation class FunctionalTest
