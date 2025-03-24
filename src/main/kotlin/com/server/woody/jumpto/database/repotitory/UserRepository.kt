package com.server.woody.jumpto.database.repotitory

import com.server.woody.jumpto.database.entities.DCUser
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<DCUser, Long>
