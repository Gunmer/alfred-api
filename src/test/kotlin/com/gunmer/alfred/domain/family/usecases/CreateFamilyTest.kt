package com.gunmer.alfred.domain.family.usecases

import com.gunmer.alfred.domain.common.DomainExceptions
import com.gunmer.alfred.domain.family.FamilyRepository
import com.gunmer.alfred.domain.shoppinglist.repositories.ShoppingListRepository
import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.domain.user.UserRepository
import com.gunmer.alfred.test.UnitTest
import io.github.glytching.junit.extension.exception.ExpectedException
import io.github.glytching.junit.extension.random.Random
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.kotlin.argThat
import org.mockito.kotlin.verify

@UnitTest
class CreateFamilyTest {
    @InjectMocks
    lateinit var useCase: CreateFamily

    @Mock
    lateinit var familyRepository: FamilyRepository
    @Mock
    lateinit var shoppingListRepository: ShoppingListRepository
    @Mock
    lateinit var userRepository: UserRepository

    @Random(excludes = ["familyId"])
    lateinit var newUser: User

    @Test
    fun `should create new family`() {
        val family = useCase(newUser)

        assertNotNull(family.id)
        assertEquals("${newUser.familyName} family", family.name)
        assertEquals(listOf(newUser), family.members)
    }

    @Test
    fun `should save family, shopping list and update user`() {
        val family = useCase(newUser)

        verify(familyRepository).save(family)
        verify(shoppingListRepository).save(argThat { shoppingList ->
            family.shoppingListId == shoppingList.id
        })
        verify(userRepository).save(argThat { user ->
            family.id == user.familyId
        })
    }

    @Test
    @ExpectedException(type = DomainExceptions.InvalidState::class)
    fun `should throw exception in createFamily when user has family`(@Random user: User) {
        useCase(user)
    }
}
