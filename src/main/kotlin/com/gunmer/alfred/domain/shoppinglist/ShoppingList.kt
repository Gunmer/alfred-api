package com.gunmer.alfred.domain.shoppinglist

data class ShoppingList(
    val id: String,
    val items: List<ShoppingItem>,
) {
}
