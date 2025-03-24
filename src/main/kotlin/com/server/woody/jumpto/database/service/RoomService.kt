package com.server.woody.jumpto.database.service

import com.server.woody.jumpto.database.entities.DCCharacter
import com.server.woody.jumpto.database.entities.DCRoom
import com.server.woody.jumpto.database.entities.DCRoomId
import com.server.woody.jumpto.database.entities.DCUser
import com.server.woody.jumpto.database.repotitory.RoomRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RoomService(@Autowired val roomRepository: RoomRepository) {
    fun createRoom(user: DCUser, character: DCCharacter): DCRoom {
        val roomId = DCRoomId(user.id!!, character.id!!)
        val room = DCRoom(roomId)
        return roomRepository.save(room)
    }

    fun getRoom(roomId: DCRoomId): DCRoom? {
        return roomRepository.findById(roomId).orElse(null)
    }

    fun getRoom(userId: Long, characterId: Long): DCRoom? {
        val roomId = DCRoomId(userId, characterId)
        return roomRepository.findById(roomId).orElse(null)
    }

}
