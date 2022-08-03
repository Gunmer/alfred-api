package com.gunmer.alfred.domain.family

interface FamilyRepository {
    fun save(family: Family)
    fun findById(familyId: String): Family?
}
