package com.server.woody.jumpto.database.entities

import jakarta.persistence.Embeddable

@Embeddable
data class DCRoomId(
    val userId: Long,
    val characterId: Long
)
