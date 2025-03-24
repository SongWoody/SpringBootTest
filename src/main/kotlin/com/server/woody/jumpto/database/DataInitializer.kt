package com.server.woody.jumpto.database

import com.server.woody.jumpto.database.service.CharacterService
import com.server.woody.jumpto.database.service.UserService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(
    private val userService: UserService,
    private val characterService: CharacterService,
): CommandLineRunner {
    override fun run(vararg args: String?) {
        generateTestUser()
        generateTestCharacter()
    }

    private fun generateTestUser() {
        val existingUser = userService.getUser(1L)
        if (existingUser == null) {
            val user = userService.createUser("TestUser")
            println("TestUser created: $user")
        } else {
            println("TestUser already exists: $existingUser")
        }
    }

    private fun generateTestCharacter() {
        val existingCharacter = characterService.getCharacter(1L)
        if (existingCharacter == null) {
            val character = characterService.createCharacter("이루다")
            println("Test character created: $character")
        } else {
            println("TestCharacter already crated: $existingCharacter")
        }
    }
}