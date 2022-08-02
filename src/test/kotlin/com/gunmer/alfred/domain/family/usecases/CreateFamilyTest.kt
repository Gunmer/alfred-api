package com.gunmer.alfred.domain.family.usecases

import com.gunmer.alfred.domain.common.DomainExceptions
import com.gunmer.alfred.domain.family.FamilyRepositoryAdapter
import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.test.UnitTest
import io.github.glytching.junit.extension.exception.ExpectedException
import io.github.glytching.junit.extension.random.Random
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.kotlin.any
import org.mockito.kotlin.verify

@UnitTest
class CreateFamilyTest {
    @InjectMocks
    lateinit var useCase: CreateFamily

    @Mock
    lateinit var familyRepositoryAdapter: FamilyRepositoryAdapter

    @Test
    fun `should create new family`(@Random(excludes = ["family"]) user: User) {

        val family = useCase(user)

        verify(familyRepositoryAdapter).create(any())
        assertNotNull(family)
        assertNotNull(family.id)
        assertEquals("${user.familyName} family", family.name)
        assertEquals(listOf(user), family.members)
    }

    @Test
    @ExpectedException(type = DomainExceptions.InvalidState::class)
    fun `should throw exception in createFamily when user has family`(@Random user: User) {
        useCase(user)
    }
}
