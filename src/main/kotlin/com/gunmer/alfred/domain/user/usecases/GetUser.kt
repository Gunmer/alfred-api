package com.gunmer.alfred.domain.user.usecases

import com.gunmer.alfred.domain.common.DomainExceptions
import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.domain.user.UserRepositoryAdapter
import org.springframework.stereotype.Service

@Service
class GetUser(
    val userRepositoryAdapter: UserRepositoryAdapter
) {
    operator fun invoke(userId: String): User {
        return userRepositoryAdapter.find(userId) ?: throw DomainExceptions.EntityNotFound("User", userId)
    }
}
