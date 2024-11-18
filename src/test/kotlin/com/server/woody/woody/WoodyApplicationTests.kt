package com.server.woody.woody

import com.server.woody.jumpto.database.question.Question
import com.server.woody.jumpto.database.repotitory.QuestionRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class WoodyApplicationTests {

	@Autowired
	private lateinit var questionRepository: QuestionRepository

	@Test
	fun contextLoads() {
	}

	@Test
	fun testJpa() {
		val q1 = Question(
				subject = "test",
				content = "testContent",
				createDate = LocalDateTime.now(),
				answerList = emptyList()
		)
		this.questionRepository.save(q1)
	}

}
