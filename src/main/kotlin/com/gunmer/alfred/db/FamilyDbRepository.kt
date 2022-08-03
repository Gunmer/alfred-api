package com.gunmer.alfred.db

import com.gunmer.alfred.db.model.FamilyDao
import com.gunmer.alfred.db.model.FamilyDao.Companion.convertTo
import com.gunmer.alfred.db.sources.FamilySource
import com.gunmer.alfred.domain.family.Family
import com.gunmer.alfred.domain.family.FamilyRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class FamilyDbRepository(
    val familySource: FamilySource,
) : FamilyRepository {
    override fun save(family: Family) {
        val familyDao = FamilyDao.convertFrom(family)
        familySource.save(familyDao)
    }

    override fun findById(familyId: String): Family? {
        val familyDao = familySource.findByIdOrNull(familyId)
        return familyDao?.convertTo()
    }
}
