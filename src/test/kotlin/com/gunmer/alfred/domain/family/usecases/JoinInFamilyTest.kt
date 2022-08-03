package com.gunmer.alfred.domain.family.usecases

import com.gunmer.alfred.domain.common.DomainExceptions
import com.gunmer.alfred.domain.family.Family
import com.gunmer.alfred.domain.family.FamilyRepository
import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.domain.user.UserRepository
import com.gunmer.alfred.test.UnitTest
import io.github.glytching.junit.extension.exception.ExpectedException
import io.github.glytching.junit.extension.random.Random
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.kotlin.argThat
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@UnitTest
class JoinInFamilyTest {
    @InjectMocks
    lateinit var useCase: JoinInFamily

    @Mock
    lateinit var familyRepository: FamilyRepository
    @Mock
    lateinit var userRepository: UserRepository

    @Random(excludes = ["familyId"])
    lateinit var currentUser: User

    @Test
    fun `should add current user in family`(@Random family: Family) {
        whenever(familyRepository.findById(family.id)).thenReturn(family)

        val result = useCase(family.id, currentUser)

        assertEquals(family.members.size + 1, result.members.size)
        verify(userRepository).save(argThat { user ->
            user.familyId == result.id
        })
    }

    @Test
    @ExpectedException(type = DomainExceptions.EntityNotFound::class)
    fun `should throw error when family not found`(@Random familyId: String) {
        whenever(familyRepository.findById(familyId)).thenReturn(null)

        useCase(familyId, currentUser)
    }
}
