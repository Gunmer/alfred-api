package com.gunmer.alfred.db.model

import com.gunmer.alfred.db.model.UserDao.Companion.convertTo
import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.test.UnitTest
import io.github.glytching.junit.extension.random.Random
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

@UnitTest
class UserDaoTest {

    @Test
    fun `should clone data from FamilyDb`(@Random userDao: UserDao) {
        val clone = userDao.convertTo()

        assertEquals(userDao.uuid,  clone.id)
        assertEquals(userDao.name,  clone.name)
        assertEquals(userDao.familyName,  clone.familyName)
    }

    @Test
    fun `should clone data from Family`(@Random user: User) {
        val clone = UserDao.convertFrom(user)

        assertEquals(user.id,  clone.uuid)
        assertEquals(user.name,  clone.name)
        assertEquals(user.familyName,  clone.familyName)
    }
}
