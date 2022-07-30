package com.gunmer.alfred.domain.user

interface UserRepositoryAdapter {
    fun find(userId: String): User?
}
