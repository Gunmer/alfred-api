package com.gunmer.alfred.domain.shoppinglist.repositories

import com.gunmer.alfred.domain.shoppinglist.ShoppingList

interface ShoppingListRepository {
    fun save(shoppingList: ShoppingList)
    fun findById(shoppingListId: String): ShoppingList?
}
