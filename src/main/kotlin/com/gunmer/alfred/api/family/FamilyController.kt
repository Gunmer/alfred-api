package com.gunmer.alfred.api.family

import com.gunmer.alfred.domain.family.usecases.CreateFamily
import com.gunmer.alfred.domain.family.usecases.JoinInFamily
import com.gunmer.alfred.domain.user.User
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/family")
class FamilyController(
    val createFamily: CreateFamily,
    val joinInFamily: JoinInFamily
) {
    @PostMapping
    fun addNewFamily(@AuthenticationPrincipal user: User) = createFamily(user)

    @PostMapping("/{familyId}/join")
    fun addNewMember(@AuthenticationPrincipal user: User, @PathVariable familyId: String) = joinInFamily(familyId, user)
}
