package com.gunmer.alfred.db.model

import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.domain.user.UserPrototype
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "user")
data class UserDb(
    @Id
    val id: String,
    @Column
    val name: String,
    @Column
    val familyName: String?,
) {
    companion object : UserPrototype<UserDb> {
        override fun cloneToPrototype(entity: User): UserDb {
            return UserDb(
                id = entity.id,
                name = entity.name,
                familyName = entity.familyName
            )
        }

        override fun UserDb.cloneFromPrototype(): User {
            return User(id, name, familyName)
        }
    }
}
