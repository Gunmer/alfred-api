package com.gunmer.alfred.db

import com.gunmer.alfred.db.model.ShoppingListDao
import com.gunmer.alfred.db.model.ShoppingListDao.Companion.convertTo
import com.gunmer.alfred.db.sources.ShoppingListSource
import com.gunmer.alfred.domain.shoppinglist.ShoppingList
import com.gunmer.alfred.domain.shoppinglist.repositories.ShoppingListRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class ShoppingListDbRepository(
    val shoppingListSource: ShoppingListSource,
) : ShoppingListRepository {
    override fun save(shoppingList: ShoppingList) {
        val shoppingListDao = ShoppingListDao.convertFrom(shoppingList)
        shoppingListSource.save(shoppingListDao)
    }

    override fun findById(shoppingListId: String): ShoppingList? {
        val shoppingListDao = shoppingListSource.findByIdOrNull(shoppingListId)
        return shoppingListDao?.convertTo()
    }
}
