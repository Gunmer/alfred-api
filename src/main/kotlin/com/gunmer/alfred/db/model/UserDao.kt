package com.gunmer.alfred.db.model

import com.gunmer.alfred.db.model.FamilyDao.Companion.convertTo
import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.domain.user.UserConverter
import javax.persistence.*

@Entity
@Table(name = "users")
data class UserDao(
    @Id
    @Column(name = "uuid")
    val uuid: String,
    @Column(name = "name")
    val name: String,
    @Column(name = "family_name")
    val familyName: String,
    @ManyToOne
    @JoinColumn(name = "family_uuid")
    val familyDao: FamilyDao?
) {
    companion object : UserConverter<UserDao> {
        override fun convertFrom(entity: User): UserDao {
            return UserDao(
                uuid = entity.id,
                name = entity.name,
                familyName = entity.familyName,
                familyDao = null,
            )
        }

        override fun UserDao.convertTo(): User {
            return User(
                id = uuid,
                name = name,
                familyName = familyName,
                family = familyDao?.convertTo(),
            )
        }
    }
}
