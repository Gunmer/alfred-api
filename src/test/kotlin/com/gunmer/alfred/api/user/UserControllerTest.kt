package com.gunmer.alfred.api.user

import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.test.FixtureGenerator
import com.gunmer.alfred.test.FunctionalTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.*


@FunctionalTest
class UserControllerTest {
    @Autowired
    lateinit var template: TestRestTemplate

    @Test
    fun `should return current user`() {
        val httpEntity = FixtureGenerator.generateHttpEntity("1", null)

        val response = template.exchange("/user/current", HttpMethod.GET, httpEntity, User::class.java)

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals("1", response.body?.id)
    }

    @Test
    fun `should return authentication error`() {
        val httpEntity = FixtureGenerator.generateHttpEntity("", null)

        val response = template.exchange("/user/current", HttpMethod.GET, httpEntity, User::class.java)

        assertEquals(HttpStatus.UNAUTHORIZED, response.statusCode)
    }
}
