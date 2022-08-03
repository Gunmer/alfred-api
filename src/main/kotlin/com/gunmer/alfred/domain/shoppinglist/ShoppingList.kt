package com.gunmer.alfred.domain.shoppinglist

data class ShoppingList(
    val id: String,
    var items: List<ShoppingItem> = listOf(),
) {
}
