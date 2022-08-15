package com.gunmer.alfred.domain.family.usecases

import com.gunmer.alfred.domain.common.DomainExceptions
import com.gunmer.alfred.domain.family.Family
import com.gunmer.alfred.domain.family.FamilyRepository
import com.gunmer.alfred.domain.shoppinglist.ShoppingList
import com.gunmer.alfred.domain.shoppinglist.repositories.ShoppingListRepository
import com.gunmer.alfred.domain.user.User
import com.gunmer.alfred.domain.user.UserRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class CreateFamily(
    val familyRepository: FamilyRepository,
    val shoppingListRepository: ShoppingListRepository,
    val userRepository: UserRepository,
) {
    operator fun invoke(user: User): Family {
        user.familyId?.let { throw DomainExceptions.InvalidState("User already has family") }

        val shoppingList = ShoppingList(
            id = UUID.randomUUID().toString(),
            items = listOf(),
        )
        shoppingListRepository.save(shoppingList)
        val family = Family(
            id = UUID.randomUUID().toString(),
            name = "${user.familyName} family",
            shoppingListId = shoppingList.id,
            members = listOf(user),
        )
        familyRepository.save(family)
        user.familyId = family.id
        userRepository.save(user)

        return family
    }
}
