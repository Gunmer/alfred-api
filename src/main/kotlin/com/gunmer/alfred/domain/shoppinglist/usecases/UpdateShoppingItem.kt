package com.gunmer.alfred.domain.shoppinglist.usecases

import com.gunmer.alfred.domain.common.DomainExceptions
import com.gunmer.alfred.domain.shoppinglist.ShoppingItem
import com.gunmer.alfred.domain.shoppinglist.ShoppingItemStatus
import com.gunmer.alfred.domain.shoppinglist.repositories.ShoppingItemRepository
import org.springframework.stereotype.Service

@Service
class UpdateShoppingItem(
    val shoppingTemRepository: ShoppingItemRepository,
) {
    operator fun invoke(itemId: String, description: String? = null, amount: Int? = null, status: ShoppingItemStatus? = null): ShoppingItem {
        var shoppingItem = shoppingTemRepository.findById(itemId) ?: throw DomainExceptions.EntityNotFound("ShoppingItem",  itemId)
        shoppingItem = shoppingItem.copy(
            description = description ?: shoppingItem.description,
            amount = amount ?: shoppingItem.amount,
            status = status ?: shoppingItem.status,
        )
        shoppingTemRepository.save(shoppingItem)
        return shoppingItem
    }
}
