package com.gunmer.alfred.domain.user

import com.gunmer.alfred.domain.family.Family

data class User(
    val id: String,
    val name: String,
    val familyName: String,
    val family: Family? = null,
)
