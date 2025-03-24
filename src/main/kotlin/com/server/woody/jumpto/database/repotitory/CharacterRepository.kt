package com.server.woody.jumpto.database.repotitory

import com.server.woody.jumpto.database.entities.DCCharacter
import org.springframework.data.jpa.repository.JpaRepository

interface CharacterRepository: JpaRepository<DCCharacter, Long>