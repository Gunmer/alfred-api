package com.gunmer.alfred.test

import org.jeasy.random.EasyRandom
import kotlin.reflect.KClass

object FixtureGenerator {
    private val generator = EasyRandom()

    fun <T : Any>generateList(type: KClass<T>, nElements: Int) = generator.objects(type.java, nElements).toList()

    fun <T : Any>generate(type: KClass<T>): T = generator.nextObject(type.java)

}
