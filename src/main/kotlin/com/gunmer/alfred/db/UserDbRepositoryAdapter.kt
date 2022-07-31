package com.gunmer.alfred.db

import com.gunmer.alfred.db.model.UserDb.Companion.cloneFromPrototype
import com.gunmer.alfred.db.repositories.UserRepository
import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.domain.user.UserRepositoryAdapter
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class UserDbRepositoryAdapter(
    val userRepository: UserRepository
) : UserRepositoryAdapter {
    override fun find(userId: String): User? {
        val userDb = userRepository.findByIdOrNull(userId)
        return userDb?.cloneFromPrototype()
    }
}
