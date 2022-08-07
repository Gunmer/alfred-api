package com.gunmer.alfred.db.sources

import com.gunmer.alfred.db.model.ShoppingItemDao
import com.gunmer.alfred.domain.shoppinglist.ShoppingItemStatus
import org.springframework.data.repository.CrudRepository

interface ShoppingItemSource : CrudRepository<ShoppingItemDao, String> {
    fun findAllByShoppingListUuidAndStatusIsNot(shoppingListId: String, status: ShoppingItemStatus): List<ShoppingItemDao>
}
