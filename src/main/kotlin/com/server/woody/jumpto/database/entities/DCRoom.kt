package com.server.woody.jumpto.database.entities

import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.Id


@Entity
data class DCRoom(
    @Id
    @Embedded
    val roomId: DCRoomId,
)
