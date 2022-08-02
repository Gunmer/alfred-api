package com.gunmer.alfred.db.model

import com.gunmer.alfred.db.model.UserDb.Companion.cloneFromPrototype
import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.test.UnitTest
import io.github.glytching.junit.extension.random.Random
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@UnitTest
class UserDbTest {

    @Test
    fun `should clone data from FamilyDb`(@Random userDb: UserDb) {
        val clone = userDb.cloneFromPrototype()

        assertEquals(userDb.uuid,  clone.id)
        assertEquals(userDb.name,  clone.name)
        assertEquals(userDb.familyName,  clone.familyName)
    }

    @Test
    fun `should clone data from Family`(@Random user: User) {
        val clone = UserDb.cloneToPrototype(user)

        assertEquals(user.id,  clone.uuid)
        assertEquals(user.name,  clone.name)
        assertEquals(user.familyName,  clone.familyName)
    }
}
