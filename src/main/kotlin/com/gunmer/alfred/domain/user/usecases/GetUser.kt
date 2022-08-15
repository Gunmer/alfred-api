package com.gunmer.alfred.domain.user.usecases

import com.gunmer.alfred.domain.common.DomainExceptions
import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.domain.user.UserRepository
import org.springframework.stereotype.Service

@Service
class GetUser(
    val userRepository: UserRepository
) {
    operator fun invoke(userId: String): User {
        return userRepository.find(userId) ?: throw DomainExceptions.EntityNotFound("User", userId)
    }
}
