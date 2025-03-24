package com.server.woody.jumpto.database.repotitory

import com.server.woody.jumpto.database.entities.DCRoom
import com.server.woody.jumpto.database.entities.DCRoomId
import org.springframework.data.jpa.repository.JpaRepository

interface RoomRepository : JpaRepository<DCRoom, DCRoomId>