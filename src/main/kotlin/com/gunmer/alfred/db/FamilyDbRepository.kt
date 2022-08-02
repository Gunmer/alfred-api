package com.gunmer.alfred.db

import com.gunmer.alfred.db.model.FamilyDao
import com.gunmer.alfred.db.sources.FamilySource
import com.gunmer.alfred.domain.family.Family
import com.gunmer.alfred.domain.family.FamilyRepository
import org.springframework.stereotype.Repository

@Repository
class FamilyDbRepository(
    val familySource: FamilySource,
) : FamilyRepository {
    override fun save(family: Family) {
        val familyDao = FamilyDao.convertFrom(family)
        familySource.save(familyDao)
    }
}
