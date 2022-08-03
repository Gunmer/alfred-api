package com.gunmer.alfred.domain.family.usecases

import com.gunmer.alfred.domain.common.DomainExceptions
import com.gunmer.alfred.domain.family.Family
import com.gunmer.alfred.domain.family.FamilyRepository
import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.domain.user.UserRepository
import org.springframework.stereotype.Service

@Service
class JoinInFamily(
    val familyRepository: FamilyRepository,
    val userRepository: UserRepository,
) {
    operator fun invoke(familyId: String, user: User): Family {
        val family = familyRepository.findById(familyId) ?: throw DomainExceptions.EntityNotFound("Family", familyId)
        user.familyId = family.id
        userRepository.save(user)

        return family.copy(members = family.members + listOf(user))
    }
}
