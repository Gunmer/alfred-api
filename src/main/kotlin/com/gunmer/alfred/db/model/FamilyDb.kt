package com.gunmer.alfred.db.model

import com.gunmer.alfred.domain.family.Family
import com.gunmer.alfred.domain.family.FamilyPrototype
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "families")
data class FamilyDb(
    @Id
    @Column(name = "uuid")
    val uuid: String,
    @Column(name = "name")
    val name: String,
    ) {

    companion object : FamilyPrototype<FamilyDb> {
        override fun cloneToPrototype(entity: Family): FamilyDb {
            return FamilyDb(
                uuid = entity.id,
                name = entity.name,
            )
        }

        override fun FamilyDb.cloneFromPrototype(): Family {
            return Family(
                id = uuid,
                name = name,
                members = listOf()
            )
        }
    }
}
