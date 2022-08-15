package com.gunmer.alfred.domain.shoppinglist.usecases

import com.gunmer.alfred.domain.common.DomainExceptions
import com.gunmer.alfred.domain.shoppinglist.ShoppingItem
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
class GetShoppingListTest {
    @InjectMocks
    private lateinit var useCase: GetShoppingList

    @Mock
    private lateinit var shoppingListRepository: ShoppingListRepository
    @Mock
    private lateinit var shoppingItemRepository: ShoppingItemRepository

    @Random
    private lateinit var shoppingListId: String

    @Test
     fun `should return shopping list`(@Random items: List<ShoppingItem>) {
        whenever(shoppingListRepository.findById(shoppingListId)).thenReturn(ShoppingList(shoppingListId))
        whenever(shoppingItemRepository.findNotArchivedItems(shoppingListId)).thenReturn(items)

        val result = useCase(shoppingListId)

        assertEquals(items, result.items)
    }

    @Test
    @ExpectedException(type = DomainExceptions.EntityNotFound::class)
    fun `should throw error when shopping list not found`() {
        whenever(shoppingListRepository.findById(shoppingListId)).thenReturn(null)

        useCase(shoppingListId)
    }
}
