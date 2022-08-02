package com.gunmer.alfred.domain.user.usecases

import com.gunmer.alfred.domain.common.DomainExceptions
import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.domain.user.UserRepositoryAdapter
import com.gunmer.alfred.test.UnitTest
import io.github.glytching.junit.extension.exception.ExpectedException
import io.github.glytching.junit.extension.random.Random
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.kotlin.whenever

@UnitTest
class GetUserTest {
    @InjectMocks
    lateinit var useCase: GetUser

    @Mock
    lateinit var userRepositoryAdapter: UserRepositoryAdapter

    @Random(excludes = ["family.members"])
    lateinit var user: User

    @Test
    fun `should return an user when given userId`(@Random userId: String) {
        whenever(userRepositoryAdapter.find(userId)).thenReturn(user)

        val currentUser = useCase(userId)

        assertEquals(currentUser, user)
    }

    @Test
    @ExpectedException(type = DomainExceptions.EntityNotFound::class)
    fun `should return exception when user not exist`(@Random userId: String) {
        whenever(userRepositoryAdapter.find(userId)).thenReturn(null)

        useCase(userId)
    }
}
