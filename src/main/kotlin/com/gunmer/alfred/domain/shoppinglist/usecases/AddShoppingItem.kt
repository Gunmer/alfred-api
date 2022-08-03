package com.gunmer.alfred.domain.shoppinglist.usecases

import com.gunmer.alfred.domain.common.DomainExceptions
import com.gunmer.alfred.domain.shoppinglist.ShoppingItem
import com.gunmer.alfred.domain.shoppinglist.ShoppingItemStatus
import com.gunmer.alfred.domain.shoppinglist.repositories.ShoppingItemRepository
import com.gunmer.alfred.domain.shoppinglist.repositories.ShoppingListRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AddShoppingItem(
    val shoppingListRepository: ShoppingListRepository,
    val shoppingItemRepository: ShoppingItemRepository,
) {
    operator fun invoke(shoppingListId: String, description: String, amount: Int? = null): ShoppingItem {
        shoppingListRepository.findById(shoppingListId) ?: throw DomainExceptions.EntityNotFound("ShoppingList", shoppingListId)

        val shoppingItem = ShoppingItem(
            id = UUID.randomUUID().toString(),
            description = description,
            status = ShoppingItemStatus.PENDING,
            amount = amount ?: 1,
            shoppingListId = shoppingListId,
        )
        shoppingItemRepository.save(shoppingItem)

        return shoppingItem
    }
}
