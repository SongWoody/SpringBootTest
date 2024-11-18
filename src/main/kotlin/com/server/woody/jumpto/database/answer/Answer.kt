package com.server.woody.jumpto.database.answer

import com.server.woody.jumpto.database.question.Question
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
data class Answer(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,
        @Column(columnDefinition = "TEXT")
        val content: String,
        val createDate: LocalDateTime,
        @ManyToOne
        val question: Question
)
