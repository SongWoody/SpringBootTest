package com.server.woody.jumpto.database

import com.server.woody.jumpto.database.entities.DCRoom
import com.server.woody.jumpto.database.service.CharacterService
import com.server.woody.jumpto.database.service.RoomService
import com.server.woody.jumpto.database.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/rooms")
class RoomController(
    @Autowired val roomService: RoomService,
    @Autowired val userService: UserService,
    @Autowired val characterService: CharacterService,
) {

    @PostMapping
    fun createRoom(@RequestParam name: String, @RequestParam userId: Long, @RequestParam characterId: Long): DCRoom {
        // 사용자와 캐릭터를 가져옴
        val user = userService.getUser(userId) ?: throw IllegalArgumentException("User not found")
        val character = characterService.getCharacter(characterId) ?: throw IllegalArgumentException("Character not found")

        return roomService.createRoom(user, character)
    }

    @GetMapping("/{userId}/{characterId}")
    fun getRoom(@PathVariable userId: Long, @PathVariable characterId: Long): DCRoom? {
        return roomService.getRoom(userId, characterId)
    }
}
