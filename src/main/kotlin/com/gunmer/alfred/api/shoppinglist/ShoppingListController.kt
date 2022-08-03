package com.gunmer.alfred.api.shoppinglist

import com.gunmer.alfred.api.shoppinglist.request.NewShoppingItemRequest
import com.gunmer.alfred.domain.shoppinglist.usecases.AddShoppingItem
import com.gunmer.alfred.domain.shoppinglist.usecases.GetShoppingList
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/shopping-list")
class ShoppingListController(
    val getShoppingList: GetShoppingList,
    val addShoppingItem: AddShoppingItem,
) {
    @GetMapping("/{shoppingListId}")
    fun shoppingList(@PathVariable shoppingListId: String) = getShoppingList(shoppingListId)

    @PostMapping("/{shoppingListId}/item")
    fun addItem(@PathVariable shoppingListId: String, @RequestBody newItem: NewShoppingItemRequest) = addShoppingItem(shoppingListId, newItem.description, newItem.amount)
}
