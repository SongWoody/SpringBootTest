package com.server.woody.jumpto.database.service

import com.server.woody.jumpto.database.entities.DCUser
import com.server.woody.jumpto.database.repotitory.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(@Autowired val userRepository: UserRepository) {

    fun createUser(name: String): DCUser {
        val user = DCUser(name = name)
        return userRepository.save(user)
    }

    fun getUser(userId: Long): DCUser? {
        return userRepository.findById(userId).orElse(null)
    }

    fun doesUserExist(userId: Long): Boolean {
        return userRepository.existsById(userId)
    }
}