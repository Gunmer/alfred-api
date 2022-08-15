package com.gunmer.alfred.api.shoppinglist.request

import com.gunmer.alfred.domain.shoppinglist.ShoppingItemStatus

data class UpdateItemRequest(
    val description: String? = null,
    val status: ShoppingItemStatus? = null,
    val amount: Int? = null,
)
