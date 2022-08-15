package com.gunmer.alfred.db.model

import com.gunmer.alfred.db.model.ShoppingItemDao.Companion.convertTo
import com.gunmer.alfred.domain.shoppinglist.ShoppingItem
import com.gunmer.alfred.test.UnitTest
import io.github.glytching.junit.extension.random.Random
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@UnitTest
class ShoppingItemDaoTest {

    @Test
    fun `should convert data from ShoppingListDao`(@Random dao: ShoppingItemDao) {
        val clone = dao.convertTo()

        assertEquals(dao.uuid,  clone.id)
        assertEquals(dao.amount,  clone.amount)
        assertEquals(dao.description,  clone.description)
        assertEquals(dao.status,  clone.status)
        assertEquals(dao.shoppingListUuid,  clone.shoppingListId)
    }

    @Test
    fun `should convert data from ShoppingList`(@Random entity: ShoppingItem) {
        val clone = ShoppingItemDao.convertFrom(entity)

        assertEquals(entity.id,  clone.uuid)
        assertEquals(entity.amount,  clone.amount)
        assertEquals(entity.description,  clone.description)
        assertEquals(entity.status,  clone.status)
        assertEquals(entity.shoppingListId,  clone.shoppingListUuid)
    }
}
