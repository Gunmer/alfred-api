package com.gunmer.alfred.api.shoppinglist.request

data class NewShoppingItemRequest(
    val description: String,
    val amount: Int?
)
