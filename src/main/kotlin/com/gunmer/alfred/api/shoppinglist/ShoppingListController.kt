package com.gunmer.alfred.api.shoppinglist

import com.gunmer.alfred.api.shoppinglist.request.NewShoppingItemRequest
import com.gunmer.alfred.api.shoppinglist.request.UpdateItemRequest
import com.gunmer.alfred.domain.shoppinglist.usecases.AddShoppingItem
import com.gunmer.alfred.domain.shoppinglist.usecases.DeleteShoppingItem
import com.gunmer.alfred.domain.shoppinglist.usecases.GetShoppingList
import com.gunmer.alfred.domain.shoppinglist.usecases.UpdateShoppingItem
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/shopping-list")
class ShoppingListController(
    val getShoppingList: GetShoppingList,
    val addShoppingItem: AddShoppingItem,
    val deleteShoppingItem: DeleteShoppingItem,
    val updateShoppingItem: UpdateShoppingItem,
) {
    @GetMapping("/{shoppingListId}")
    fun shoppingList(@PathVariable shoppingListId: String) = getShoppingList(shoppingListId)

    @PostMapping("/{shoppingListId}/item")
    fun addItem(@PathVariable shoppingListId: String, @RequestBody newItem: NewShoppingItemRequest) = addShoppingItem(shoppingListId, newItem.description, newItem.amount)

    @DeleteMapping("/{shoppingListId}/item/{shoppingItemId}")
    fun removeItem(@PathVariable shoppingItemId: String) = deleteShoppingItem(shoppingItemId)

    @PutMapping("/{shoppingListId}/item/{shoppingItemId}")
    fun updateItem(@PathVariable shoppingItemId: String, @RequestBody updateItemRequest: UpdateItemRequest) = updateShoppingItem(shoppingItemId, updateItemRequest.description, updateItemRequest.amount, updateItemRequest.status)
}
