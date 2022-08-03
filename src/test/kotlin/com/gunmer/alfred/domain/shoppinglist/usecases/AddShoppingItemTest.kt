package com.gunmer.alfred.domain.shoppinglist.usecases

import com.gunmer.alfred.domain.common.DomainExceptions
import com.gunmer.alfred.domain.shoppinglist.ShoppingItemStatus
import com.gunmer.alfred.domain.shoppinglist.ShoppingList
import com.gunmer.alfred.domain.shoppinglist.repositories.ShoppingItemRepository
import com.gunmer.alfred.domain.shoppinglist.repositories.ShoppingListRepository
import com.gunmer.alfred.test.UnitTest
import io.github.glytching.junit.extension.exception.ExpectedException
import io.github.glytching.junit.extension.random.Random
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.kotlin.whenever

@UnitTest
class AddShoppingItemTest {
    @InjectMocks
    private lateinit var useCase: AddShoppingItem

    @Mock
    private lateinit var shoppingListRepository: ShoppingListRepository
    @Mock
    private lateinit var shoppingItemRepository: ShoppingItemRepository

    @Random
    private lateinit var itemDescription: String

    @Test
    fun `should  add item to shopping list`(@Random shoppingList: ShoppingList) {
        whenever(shoppingListRepository.findById(shoppingList.id)).thenReturn(shoppingList)

        val shoppingItem = useCase(shoppingList.id, itemDescription)

        assertEquals(shoppingList.id,  shoppingItem.shoppingListId)
        assertEquals(itemDescription,  shoppingItem.description)
        assertEquals(ShoppingItemStatus.PENDING,  shoppingItem.status)
        assertEquals(1,  shoppingItem.amount)
    }

    @Test
    fun `should add item to shopping list with 5 items`(@Random shoppingList: ShoppingList) {
        whenever(shoppingListRepository.findById(shoppingList.id)).thenReturn(shoppingList)
        val amount = 5

        val shoppingItem = useCase(shoppingList.id, itemDescription, amount)

        assertEquals(shoppingList.id,  shoppingItem.shoppingListId)
        assertEquals(itemDescription,  shoppingItem.description)
        assertEquals(ShoppingItemStatus.PENDING,  shoppingItem.status)
        assertEquals(amount,  shoppingItem.amount)
    }

    @Test
    @ExpectedException(type = DomainExceptions.EntityNotFound::class)
    fun `should throw error when shopping list not found`(@Random shoppingListId: String) {
        whenever(shoppingListRepository.findById(shoppingListId)).thenReturn(null)

        useCase(shoppingListId, itemDescription)
    }
}
