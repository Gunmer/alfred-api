package com.gunmer.alfred.db

import com.gunmer.alfred.db.model.FamilyDb
import com.gunmer.alfred.db.repositories.FamilyRepository
import com.gunmer.alfred.domain.family.Family
import com.gunmer.alfred.domain.family.FamilyRepositoryAdapter
import org.springframework.stereotype.Repository

@Repository
class FamilyDbRepositoryAdapter(
    val familyRepository: FamilyRepository,
) : FamilyRepositoryAdapter {
    override fun create(family: Family) {
        val familyDb = FamilyDb.cloneToPrototype(family)
        familyRepository.save(familyDb)
    }
}
