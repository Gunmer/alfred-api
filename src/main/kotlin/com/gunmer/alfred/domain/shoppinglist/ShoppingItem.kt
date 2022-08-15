package com.gunmer.alfred.domain.shoppinglist

data class ShoppingItem (
    val id: String,
    val description: String,
    val status: ShoppingItemStatus,
    val amount: Int,
    val shoppingListId: String
)
