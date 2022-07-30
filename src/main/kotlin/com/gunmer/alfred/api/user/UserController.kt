package com.gunmer.alfred.api.user

import com.gunmer.alfred.domain.user.User
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {
    @GetMapping("/current")
    fun getUser(@AuthenticationPrincipal use: User) = ResponseEntity.ok(use)
}
