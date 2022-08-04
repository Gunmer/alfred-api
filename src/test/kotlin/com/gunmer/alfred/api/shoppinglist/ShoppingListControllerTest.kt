package com.gunmer.alfred.api.shoppinglist

import com.gunmer.alfred.api.shoppinglist.request.NewShoppingItemRequest
import com.gunmer.alfred.domain.shoppinglist.ShoppingItem
import com.gunmer.alfred.domain.shoppinglist.ShoppingList
import com.gunmer.alfred.test.FixtureGenerator
import com.gunmer.alfred.test.FunctionalTest
import io.github.glytching.junit.extension.random.Random
import org.junit.jupiter.api.Assertions.assertEquals
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

        assertEquals(HttpStatus.OK, response.statusCode)
    }

    @Test
    fun `should response NOT_FOUND when shopping list not exist`(@Random shoppingListId: String) {
        val httpEntity = FixtureGenerator.generateHttpEntity("1", null)

        val response = template.exchange("/shopping-list/$shoppingListId", HttpMethod.GET, httpEntity, String::class.java)

        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
    }

    @Test
    fun `should add item in list`(@Random request: NewShoppingItemRequest) {
        val shoppingListId = "1"
        val httpEntity = FixtureGenerator.generateHttpEntity("1", request)

        val response = template.exchange("/shopping-list/$shoppingListId/item", HttpMethod.POST, httpEntity, ShoppingItem::class.java)

        assertEquals(HttpStatus.OK, response.statusCode)
        assertEquals(request.description, response.body?.description)
        assertEquals(request.amount, response.body?.amount)
    }

    @Test
    fun `should response with NOT_FOUND when list not exist`(@Random request: NewShoppingItemRequest) {
        val shoppingListId = "invent"
        val httpEntity = FixtureGenerator.generateHttpEntity("1", request)

        val response = template.exchange("/shopping-list/$shoppingListId/item", HttpMethod.POST, httpEntity, String::class.java)

        assertEquals(HttpStatus.NOT_FOUND, response.statusCode)
    }

    @Test
    fun `should remove item`() {
        val shoppingListId = "1"
        val shoppingItemId = "1"
        val httpEntity = FixtureGenerator.generateHttpEntity("1", null)

        val response = template.exchange("/shopping-list/$shoppingListId/item/$shoppingItemId", HttpMethod.DELETE, httpEntity, String::class.java)

        assertEquals(HttpStatus.OK, response.statusCode)
    }

}
