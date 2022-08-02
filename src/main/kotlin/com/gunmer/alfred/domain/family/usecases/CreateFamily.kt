package com.gunmer.alfred.domain.family.usecases

import com.gunmer.alfred.domain.common.DomainExceptions
import com.gunmer.alfred.domain.family.Family
import com.gunmer.alfred.domain.family.FamilyRepository
import com.gunmer.alfred.domain.user.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class CreateFamily(
    val familyRepository: FamilyRepository,
) {
    operator fun invoke(user: User): Family {
        user.family?.let { throw DomainExceptions.InvalidState("User already has family") }
        val family = Family(
            id = UUID.randomUUID().toString(),
            name = "${user.familyName} family",
            members = listOf(user)
        )
        familyRepository.create(family)

        return family
    }
}
