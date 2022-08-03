package com.gunmer.alfred.api.shoppinglist

import com.gunmer.alfred.domain.shoppinglist.ShoppingList
import com.gunmer.alfred.test.FixtureGenerator
import com.gunmer.alfred.test.FunctionalTest
import io.github.glytching.junit.extension.random.Random
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus

@FunctionalTest
class ShoppingListControllerTest {
    @Autowired
    private lateinit var template: TestRestTemplate


    @Test
    fun `should response OK when shopping list exist`() {
        val shoppingListId = "1"
        val httpEntity = FixtureGenerator.generateHttpEntity("1", null)

        val response = template.exchange("/shopping-list/$shoppingListId", HttpMethod.GET, httpEntity, ShoppingList::class.java)

        Assertions.assertEquals(HttpStatus.OK, response.statusCode)
    }

    @Test
    fun `should response NOT_FOUND when shopping list not exist`(@Random shoppingListId: String) {
        val httpEntity = FixtureGenerator.generateHttpEntity("1", null)

        val response = template.exchange("/shopping-list/$shoppingListId", HttpMethod.GET, httpEntity, String::class.java)

        Assertions.assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
    }

}
