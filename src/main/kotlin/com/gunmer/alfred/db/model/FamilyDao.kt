package com.gunmer.alfred.db.model

import com.gunmer.alfred.db.model.UserDao.Companion.convertTo
import com.gunmer.alfred.domain.family.Family
import com.gunmer.alfred.domain.family.FamilyConverter
import javax.persistence.*

@Entity
@Table(name = "families")
data class FamilyDao(
    @Id
    @Column(name = "uuid")
    val uuid: String,
    @Column(name = "name")
    val name: String,
    @Column(name = "shopping_list_uuid")
    val shoppingListUuid: String,
    @OneToMany(mappedBy = "familyUuid")
    val members: List<UserDao>
    ) {

    companion object : FamilyConverter<FamilyDao> {
        override fun convertFrom(entity: Family): FamilyDao {
            return FamilyDao(
                uuid = entity.id,
                name = entity.name,
                shoppingListUuid = entity.shoppingListId,
                members = entity.members.map(UserDao::convertFrom)
            )
        }

        override fun FamilyDao.convertTo(): Family {
            return Family(
                id = uuid,
                name = name,
                shoppingListId = shoppingListUuid,
                members = members.map { it.convertTo() }
            )
        }
    }
}
