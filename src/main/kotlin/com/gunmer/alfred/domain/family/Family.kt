package com.gunmer.alfred.domain.family

import com.gunmer.alfred.domain.user.User

data class Family(
    val id: String,
    val name: String,
    val members: List<User>
)
