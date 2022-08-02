package com.gunmer.alfred.db.model

import com.gunmer.alfred.db.model.FamilyDb.Companion.cloneFromPrototype
import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.domain.user.UserPrototype
import javax.persistence.*

@Entity
@Table(name = "users")
data class UserDb(
    @Id
    @Column(name = "uuid")
    val uuid: String,
    @Column(name = "name")
    val name: String,
    @Column(name = "family_name")
    val familyName: String,
    @ManyToOne
    @JoinColumn(name = "family_uuid")
    val familyDb: FamilyDb?
) {
    companion object : UserPrototype<UserDb> {
        override fun cloneToPrototype(entity: User): UserDb {
            return UserDb(
                uuid = entity.id,
                name = entity.name,
                familyName = entity.familyName,
                familyDb = null,
            )
        }

        override fun UserDb.cloneFromPrototype(): User {
            return User(
                id = uuid,
                name = name,
                familyName = familyName,
                family = familyDb?.cloneFromPrototype(),
            )
        }
    }
}
