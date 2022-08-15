package com.gunmer.alfred.domain.shoppinglist.usecases

import com.gunmer.alfred.domain.common.DomainExceptions
import com.gunmer.alfred.domain.shoppinglist.ShoppingItem
import com.gunmer.alfred.domain.shoppinglist.ShoppingItemStatus
import com.gunmer.alfred.domain.shoppinglist.repositories.ShoppingItemRepository
import com.gunmer.alfred.test.UnitTest
import io.github.glytching.junit.extension.exception.ExpectedException
import io.github.glytching.junit.extension.random.Random
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@UnitTest
class UpdateShoppingItemTest {
    @InjectMocks
    private lateinit var useCase: UpdateShoppingItem

    @Mock
    private lateinit var shoppingItemRepository: ShoppingItemRepository

    @Random
    private lateinit var shoppingItem: ShoppingItem

    @Test
    fun `should update status`(@Random status: ShoppingItemStatus) {
        val itemId = "2"
        whenever(shoppingItemRepository.findById(itemId)).thenReturn(shoppingItem)

        val item = useCase(itemId, status = status)

        assertEquals(status, item.status)
        verify(shoppingItemRepository).save(any())
    }

    @Test
    fun `should update amount`(@Random amount: Int) {
        val itemId = "2"
        whenever(shoppingItemRepository.findById(itemId)).thenReturn(shoppingItem)

        val item = useCase(itemId, amount = amount)

        assertEquals(amount, item.amount)
        verify(shoppingItemRepository).save(any())
    }

    @Test
    fun `should update description`(@Random description: String) {
        val itemId = "2"
        whenever(shoppingItemRepository.findById(itemId)).thenReturn(shoppingItem)

        val item = useCase(itemId, description = description)

        assertEquals(description, item.description)
        verify(shoppingItemRepository).save(any())
    }

    @Test
    @ExpectedException(type = DomainExceptions.EntityNotFound::class)
    fun `should throw exception when item not found`() {
        val itemId = "2"
        whenever(shoppingItemRepository.findById(itemId)).thenReturn(null)

        useCase(itemId)
    }
}
