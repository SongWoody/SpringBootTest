package com.server.woody.jumpto.database.repotitory

import com.server.woody.jumpto.database.answer.Answer
import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepository: JpaRepository<Answer, Int> {
}