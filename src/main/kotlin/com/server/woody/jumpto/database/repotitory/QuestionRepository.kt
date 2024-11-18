package com.server.woody.jumpto.database.repotitory

import com.server.woody.jumpto.database.question.Question
import org.springframework.data.jpa.repository.JpaRepository

interface QuestionRepository: JpaRepository<Question, Int>