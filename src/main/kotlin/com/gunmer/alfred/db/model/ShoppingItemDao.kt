package com.gunmer.alfred.db.model

import com.gunmer.alfred.domain.shoppinglist.ShoppingItem
import com.gunmer.alfred.domain.shoppinglist.ShoppingItemStatus
import com.gunmer.alfred.domain.shoppinglist.converts.ShoppingItemConverter
import javax.persistence.*

@Entity
@Table(name = "shopping_items")
data class ShoppingItemDao(
    @Id
    @Column(name = "uuid")
    val uuid: String,
    @Column(name = "description")
    val description: String,
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    val status: ShoppingItemStatus,
    @Column(name = "amount")
    val amount: Int,
    @Column(name = "shopping_list_uuid")
    val shoppingListUuid: String
) {
    companion object : ShoppingItemConverter<ShoppingItemDao> {
        override fun convertFrom(entity: ShoppingItem): ShoppingItemDao {
            return ShoppingItemDao(
                uuid = entity.id,
                description = entity.description,
                status = entity.status,
                amount = entity.amount,
                shoppingListUuid = entity.shoppingListId,
            )
        }

        override fun ShoppingItemDao.convertTo(): ShoppingItem {
            return ShoppingItem(
                id = uuid,
                description = description,
                status = status,
                amount = amount,
                shoppingListId = shoppingListUuid,
            )
        }

    }
}
