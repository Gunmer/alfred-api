package com.gunmer.alfred.db.model

import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.domain.user.UserPrototype
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class UserDb(
    @Id
    @Column(name = "uuid")
    val id: String,
    @Column(name = "name")
    val name: String,
    @Column(name = "family_name")
    val familyName: String,
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
