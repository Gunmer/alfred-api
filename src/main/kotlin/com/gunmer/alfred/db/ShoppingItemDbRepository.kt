package com.gunmer.alfred.db

import com.gunmer.alfred.db.model.ShoppingItemDao
import com.gunmer.alfred.db.model.ShoppingItemDao.Companion.convertTo
import com.gunmer.alfred.db.sources.ShoppingItemSource
import com.gunmer.alfred.domain.shoppinglist.ShoppingItem
import com.gunmer.alfred.domain.shoppinglist.ShoppingItemStatus
import com.gunmer.alfred.domain.shoppinglist.repositories.ShoppingItemRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class ShoppingItemDbRepository(
    val shoppingItemSource: ShoppingItemSource
) : ShoppingItemRepository {
    override fun save(shoppingItem: ShoppingItem) {
        val shoppingItemDao = ShoppingItemDao.convertFrom(shoppingItem)
        shoppingItemSource.save(shoppingItemDao)
    }

    override fun findNotArchivedItems(shoppingListId: String): List<ShoppingItem> {
        val itemDaos = shoppingItemSource.findAllByShoppingListUuidAndStatusIsNot(shoppingListId, ShoppingItemStatus.ARCHIVED)
        return itemDaos.map { it.convertTo() }
    }

    override fun remove(shoppingItemId: String) {
        shoppingItemSource.deleteById(shoppingItemId)
    }

    override fun findById(shoppingItemId: String): ShoppingItem? {
        val shoppingItemDao = shoppingItemSource.findByIdOrNull(shoppingItemId)
        return shoppingItemDao?.convertTo()
    }
}
