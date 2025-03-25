package com.server.woody.jumpto.database.service

import com.server.woody.jumpto.database.entities.DCCharacter
import com.server.woody.jumpto.database.repotitory.CharacterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class CharacterService(
    @Autowired val characterRepository: CharacterRepository
) {

    fun createCharacter(name: String): DCCharacter {
        val character = DCCharacter(name = name)
        return characterRepository.save(character)
    }

    fun getCharacter(characterId: Long): DCCharacter? {
        return characterRepository.findById(characterId).orElse(null)
    }

    fun getCharacters(index: Int, count: Int): Page<DCCharacter> {
        val pageable = PageRequest.of(index, count)
        return characterRepository.findAll(pageable)
    }
}