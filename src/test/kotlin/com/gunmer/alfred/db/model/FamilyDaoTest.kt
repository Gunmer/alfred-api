package com.gunmer.alfred.db.model

import com.gunmer.alfred.db.model.FamilyDao.Companion.convertTo
import com.gunmer.alfred.domain.family.Family
import com.gunmer.alfred.test.UnitTest
import io.github.glytching.junit.extension.random.Random
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@UnitTest
class FamilyDaoTest {

    @Test
    fun `should clone data from FamilyDb`(@Random familyDao: FamilyDao) {
        val clone = familyDao.convertTo()

        assertEquals(familyDao.uuid,  clone.id)
        assertEquals(familyDao.name,  clone.name)
    }

    @Test
    fun `should clone data from Family`(@Random family: Family) {
        val clone = FamilyDao.convertFrom(family)

        assertEquals(family.id,  clone.uuid)
        assertEquals(family.name,  clone.name)
    }
}
