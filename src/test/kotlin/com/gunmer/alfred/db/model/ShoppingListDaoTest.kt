package com.gunmer.alfred.db.model

import com.gunmer.alfred.db.model.ShoppingListDao.Companion.convertTo
import com.gunmer.alfred.domain.shoppinglist.ShoppingList
import com.gunmer.alfred.test.UnitTest
import io.github.glytching.junit.extension.random.Random
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@UnitTest
class ShoppingListDaoTest {

    @Test
    fun `should convert data from ShoppingListDao`(@Random shoppingListDao: ShoppingListDao) {
        val clone = shoppingListDao.convertTo()

        assertEquals(shoppingListDao.uuid,  clone.id)
    }

    @Test
    fun `should convert data from ShoppingList`(@Random shoppingList: ShoppingList) {
        val clone = ShoppingListDao.convertFrom(shoppingList)

        assertEquals(shoppingList.id,  clone.uuid)
    }
}
