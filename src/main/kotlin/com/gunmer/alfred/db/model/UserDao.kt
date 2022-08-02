package com.gunmer.alfred.db.model

import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.domain.user.UserConverter
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

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
    @Column(name = "family_uuid")
    val familyUuid: String?
) {
    companion object : UserConverter<UserDao> {
        override fun convertFrom(entity: User): UserDao {
            return UserDao(
                uuid = entity.id,
                name = entity.name,
                familyName = entity.familyName,
                familyUuid = entity.familyId,
            )
        }

        override fun UserDao.convertTo(): User {
            return User(
                id = uuid,
                name = name,
                familyName = familyName,
                familyId = familyUuid,
            )
        }
    }
}
