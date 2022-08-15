package com.gunmer.alfred.test

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

object FixtureGenerator {


    fun <T : Any> generateHttpEntity(token: String, body: T?, contentType: MediaType? = MediaType.APPLICATION_JSON): HttpEntity<T> {
        val headers = HttpHeaders()
        headers.setBearerAuth(token)
        headers.contentType = contentType
        return HttpEntity(body, headers)
    }
}
