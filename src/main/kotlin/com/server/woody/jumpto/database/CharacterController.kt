package com.server.woody.jumpto.database
import com.server.woody.jumpto.database.entities.DCCharacter
import com.server.woody.jumpto.database.service.CharacterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/characters")
class CharacterController(@Autowired val characterService: CharacterService) {

    @PostMapping
    fun createCharacter(@RequestParam name: String): DCCharacter {
        return characterService.createCharacter(name)
    }

    @GetMapping("/{characterId}")
    fun getCharacter(@PathVariable characterId: Long): DCCharacter? {
        return characterService.getCharacter(characterId)
    }
}