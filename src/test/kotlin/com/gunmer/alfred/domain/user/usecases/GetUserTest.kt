package com.gunmer.alfred.domain.user.usecases

import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.domain.user.UserRepositoryAdapter
import com.gunmer.alfred.test.FixtureGenerator
import com.gunmer.alfred.test.UnitTest
import org.junit.jupiter.api.Assertions.assertNotNull
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

    @Test
    fun `should return an user when given userId `() {
        val userId = FixtureGenerator.generate(String::class)
        whenever(userRepositoryAdapter.find(userId)).thenReturn(FixtureGenerator.generate(User::class))

        val user = useCase(userId)

        assertNotNull(user)
    }
}
