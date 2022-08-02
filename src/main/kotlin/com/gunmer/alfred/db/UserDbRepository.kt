package com.gunmer.alfred.db

import com.gunmer.alfred.db.model.UserDao.Companion.convertTo
import com.gunmer.alfred.db.repositories.UserSource
import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.domain.user.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class UserDbRepository(
    val userSource: UserSource
) : UserRepository {
    override fun find(userId: String): User? {
        val userDb = userSource.findByIdOrNull(userId)
        return userDb?.convertTo()
    }
}
