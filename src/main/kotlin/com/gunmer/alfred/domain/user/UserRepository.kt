package com.gunmer.alfred.domain.user

interface UserRepository {
    fun find(userId: String): User?
    fun save(user: User)
}
