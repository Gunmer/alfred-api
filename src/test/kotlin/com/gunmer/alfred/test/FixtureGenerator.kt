package com.gunmer.alfred.test

import org.jeasy.random.EasyRandom
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import kotlin.reflect.KClass

object FixtureGenerator {
    private val generator = EasyRandom()

    fun <T : Any>generateList(type: KClass<T>, nElements: Int) = generator.objects(type.java, nElements).toList()

    fun <T : Any>generate(type: KClass<T>): T = generator.nextObject(type.java)

    fun <T : Any>generateHttpEntity(token: String, body: T?, contentType: MediaType? = MediaType.APPLICATION_JSON): HttpEntity<T> {
        val headers = HttpHeaders()
        headers.setBearerAuth(token)
        headers.contentType = contentType
        return HttpEntity(body, headers)
    }
}
