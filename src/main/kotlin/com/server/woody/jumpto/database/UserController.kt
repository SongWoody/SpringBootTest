package com.server.woody.jumpto.database

import com.server.woody.jumpto.database.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    @Autowired val userService: UserService,
) {

    @GetMapping("/users/{userId}/exist")
    fun checkIfUserExist(
        @PathVariable userId: Long
    ): String {
        println("call checkIfUserExist API")
        return if (userService.doesUserExist(userId)) {
            """{ "result": "exist"}"""
        } else {
            """{ "result": "noUser"}"""
        }
    }
}