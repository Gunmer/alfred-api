package com.gunmer.alfred.db.model

import com.gunmer.alfred.db.model.FamilyDb.Companion.cloneFromPrototype
import com.gunmer.alfred.domain.family.Family
import com.gunmer.alfred.test.UnitTest
import io.github.glytching.junit.extension.random.Random
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@UnitTest
class FamilyDbTest {

    @Test
    fun `should clone data from FamilyDb`(@Random familyDb: FamilyDb) {
        val clone = familyDb.cloneFromPrototype()

        assertEquals(familyDb.uuid,  clone.id)
        assertEquals(familyDb.name,  clone.name)
    }

    @Test
    fun `should clone data from Family`(@Random family: Family) {
        val clone = FamilyDb.cloneToPrototype(family)

        assertEquals(family.id,  clone.uuid)
        assertEquals(family.name,  clone.name)
    }
}
