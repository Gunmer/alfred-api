package com.gunmer.alfred.domain.shoppinglist.usecases

import com.gunmer.alfred.domain.shoppinglist.repositories.ShoppingItemRepository
import org.springframework.stereotype.Service

@Service
class DeleteShoppingItem(
    val shoppingItemRepository: ShoppingItemRepository,
) {
    operator fun invoke(itemId: String) {
        shoppingItemRepository.remove(itemId)
    }
}
