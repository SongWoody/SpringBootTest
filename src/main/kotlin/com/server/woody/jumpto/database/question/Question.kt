package com.server.woody.jumpto.database.question

import com.server.woody.jumpto.database.answer.Answer
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.time.LocalDateTime

@Entity
data class Question(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,
        @Column(length = 200)
        val subject: String,
        @Column(columnDefinition = "TET")
        val content: String,
        val createDate: LocalDateTime,
        @OneToMany(mappedBy = "question", cascade = [CascadeType.REMOVE ])
        val answerList: List<Answer>
)
