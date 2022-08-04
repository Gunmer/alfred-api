package com.gunmer.alfred.domain.shoppinglist.repositories

import com.gunmer.alfred.domain.shoppinglist.ShoppingItem

interface ShoppingItemRepository {
    fun save(shoppingItem: ShoppingItem)
    fun findNotArchivedItems(shoppingListId: String): List<ShoppingItem>
    fun remove(shoppingItemId: String)
}
