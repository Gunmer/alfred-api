package com.gunmer.alfred.db.model

import com.gunmer.alfred.domain.shoppinglist.ShoppingList
import com.gunmer.alfred.domain.shoppinglist.converts.ShoppingListConverter
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "shopping_lists")
data class ShoppingListDao(
    @Id
    @Column(name = "uuid")
    val uuid: String
) {
    companion object : ShoppingListConverter<ShoppingListDao> {
        override fun convertFrom(entity: ShoppingList): ShoppingListDao {
            return ShoppingListDao(
                uuid = entity.id,
            )
        }

        override fun ShoppingListDao.convertTo(): ShoppingList {
            return ShoppingList(
                id = uuid,
                items = listOf(),
            )
        }
    }
}
