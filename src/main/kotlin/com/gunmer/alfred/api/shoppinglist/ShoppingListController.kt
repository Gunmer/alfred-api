package com.gunmer.alfred.api.shoppinglist

import com.gunmer.alfred.domain.shoppinglist.usecases.GetShoppingList
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/shopping-list")
class ShoppingListController(
    val getShoppingList: GetShoppingList,
) {
    @GetMapping("/{shoppingListId}")
    fun shoppingList(@PathVariable shoppingListId: String) = getShoppingList(shoppingListId)
}
