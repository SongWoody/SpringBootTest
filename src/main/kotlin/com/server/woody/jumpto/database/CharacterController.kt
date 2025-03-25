package com.server.woody.jumpto.database
import com.server.woody.jumpto.database.entities.DCCharacter
import com.server.woody.jumpto.database.service.CharacterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/characters")
class CharacterController(@Autowired val characterService: CharacterService) {

//    @PostMapping
//    fun createCharacter(@RequestParam name: String): DCCharacter {
//        return characterService.createCharacter(name)
//    }
//
//    @GetMapping("/{characterId}")
//    fun getCharacter(@PathVariable characterId: Long): DCCharacter? {
//        return characterService.getCharacter(characterId)
//    }

    @GetMapping
    fun getCharacters(
        @RequestParam index: Int,
        @RequestParam count: Int
    ): ResponseEntity<List<DCCharacter>> {
        println("call getCharacters index: $index, count: $count")
        val page = characterService.getCharacters(index, count)
        return ResponseEntity.ok(page.content) // 페이지의 content 부분만 반환
    }
}