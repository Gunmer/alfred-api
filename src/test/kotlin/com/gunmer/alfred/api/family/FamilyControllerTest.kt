package com.gunmer.alfred.api.family

import com.gunmer.alfred.domain.family.Family
import com.gunmer.alfred.test.FixtureGenerator
import com.gunmer.alfred.test.FunctionalTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus

@FunctionalTest
class FamilyControllerTest {
    @Autowired
    lateinit var template: TestRestTemplate

    @Test
    fun `should create family when current user not have family`() {
        val httpEntity = FixtureGenerator.generateHttpEntity("2", null)

        val response = template.exchange("/family", HttpMethod.POST, httpEntity, Family::class.java)

        assertEquals(HttpStatus.OK, response.statusCode)
    }

    @Test
    fun `should return CONFLICT error when current user have  family`() {
        val httpEntity = FixtureGenerator.generateHttpEntity("1", null)

        val response = template.exchange("/family", HttpMethod.POST, httpEntity, String::class.java)

        assertEquals(HttpStatus.CONFLICT, response.statusCode)
    }
}
