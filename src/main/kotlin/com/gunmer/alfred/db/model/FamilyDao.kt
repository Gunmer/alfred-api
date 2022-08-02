package com.gunmer.alfred.db.model

import com.gunmer.alfred.domain.family.Family
import com.gunmer.alfred.domain.family.FamilyConverter
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "families")
data class FamilyDao(
    @Id
    @Column(name = "uuid")
    val uuid: String,
    @Column(name = "name")
    val name: String,
    ) {

    companion object : FamilyConverter<FamilyDao> {
        override fun convertFrom(entity: Family): FamilyDao {
            return FamilyDao(
                uuid = entity.id,
                name = entity.name,
            )
        }

        override fun FamilyDao.convertTo(): Family {
            return Family(
                id = uuid,
                name = name,
                members = listOf()
            )
        }
    }
}
