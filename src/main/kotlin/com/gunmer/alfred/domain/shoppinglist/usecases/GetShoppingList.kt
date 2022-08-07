package com.gunmer.alfred.domain.shoppinglist.usecases

import com.gunmer.alfred.domain.common.DomainExceptions
import com.gunmer.alfred.domain.shoppinglist.ShoppingList
import com.gunmer.alfred.domain.shoppinglist.repositories.ShoppingItemRepository
import com.gunmer.alfred.domain.shoppinglist.repositories.ShoppingListRepository
import org.springframework.stereotype.Service

@Service
class GetShoppingList(
    val shoppingListRepository: ShoppingListRepository,
    val shoppingItemRepository: ShoppingItemRepository,
) {
    operator fun invoke(listId: String): ShoppingList {
        val shoppingList = shoppingListRepository.findById(listId) ?: throw DomainExceptions.EntityNotFound("ShoppingList", listId)
        shoppingList.items = shoppingItemRepository.findNotArchivedItems(shoppingList.id)

        return shoppingList
    }
}
