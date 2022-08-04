package com.gunmer.alfred.domain.shoppinglist.usecases

import com.gunmer.alfred.domain.shoppinglist.repositories.ShoppingItemRepository
import com.gunmer.alfred.test.UnitTest
import io.github.glytching.junit.extension.random.Random
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.kotlin.verify

@UnitTest
class DeleteShoppingItemTest {
    @InjectMocks
    private lateinit var useCase: DeleteShoppingItem

    @Mock
    private lateinit var shoppingItemRepository: ShoppingItemRepository

    @Test
    fun `should delete item`(@Random itemId: String) {
        useCase(itemId)

        verify(shoppingItemRepository).remove(itemId)
    }
}
