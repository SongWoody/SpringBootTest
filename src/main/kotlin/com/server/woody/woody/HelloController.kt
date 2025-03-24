package com.server.woody.woody

import com.server.woody.woody.database.ProductService
import com.server.woody.woody.database.entities.Members
import com.server.woody.woody.dto.TestDto
import com.server.woody.woody.service.MyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.time.Duration
import java.time.LocalTime
import java.util.stream.Stream


@Controller
class HelloController {

    @Autowired
    lateinit var myService: MyService

    @Autowired
    lateinit var productService: ProductService

    @PostMapping("/products")
    fun createProduct(@RequestBody member: Members): Members {
        println("member $member")
        return productService.saveProduct(member)
    }

    @GetMapping("/hello")
    @ResponseBody
    fun hello(): String{
        return "Hello World2223344445555"
    }

    @GetMapping("/main")
    @ResponseBody
    fun main(): String {
        println("get main")
        return "it's /main"
    }

    @GetMapping("/event", produces = [MediaType.TEXT_EVENT_STREAM_VALUE + ";charset=UTF-8"])
    fun sseEvent(): Flux<String> {
        val response = generateResponse()
        // UTF-8로 인코딩된 문자열을 명시적으로 처리
        val utf8Response = String(response.toByteArray(StandardCharsets.UTF_8), StandardCharsets.UTF_8)
        return Flux.fromIterable(utf8Response.toList().map { it.toString() })
            .delayElements(Duration.ofMillis(50)) // 50ms 간격
            .concatWith(Flux.just("\n")) // 스트림 종료
    }

    private fun generateResponse(): String {
        return """
            안녕하세요! 👋 저는 AI 챗봇입니다. 
            궁금한 것이 있으시면 언제든지 질문해주세요. 
            Kotlin, Spring Boot, SSE 등에 대해 답변 가능합니다. 😊👍
        """.trimIndent()
    }

    @GetMapping("/.well-known/apple-app-site-association", produces = ["application/json; charset=UTF-8"])
    @ResponseBody
    fun aasa(): String {
        val resource = ClassPathResource("apple-app-site-association.json")
        try {
            val br = BufferedReader(InputStreamReader(resource.inputStream))
            val stringBuilder = StringBuilder()
            var line: String? = br.readLine()
            while (line != null) {
                stringBuilder.append(line)
                line = br.readLine()
            }

            val resultString: String = stringBuilder.toString()
            return resultString
        } catch (e: Exception) {
            println("fila")
        }
        return "it's /main"
    }

    @PostMapping("/test", produces = ["application/json; charset=UTF-8"])
    @ResponseBody
    fun test(): String {
        return "{\"test\":\"test\"}"
    }

    @PostMapping("/create", produces = ["application/json; charset=UTF-8"])
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    fun create(): String {
        return "{\"test\":\"test\"}"
    }

    @PostMapping("/create1", produces = ["application/json; charset=UTF-8"])
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    fun create1(): String {
        return "{\"test\":\"test\"}"
    }

    @PostMapping("/create2", produces = ["application/json; charset=UTF-8"])
    @ResponseStatus(HttpStatus.NOT_MODIFIED)
    @ResponseBody
    fun create2(): String {
        return "{\"test\":\"test\"}"
    }

    @PostMapping("/v1/registration/options", produces = ["application/json; charset=UTF-8"])
    @ResponseBody
    fun dummyRegistration(): String {
        println("dummyRegistration")
        return """{
"result": {
"retCode": "S00000",
"retMsg": ""
},
"retData": {
"rp": {"id": "rpId", "name": "rpName"},
"user": {"id":"userId","name": "userName", "displayName": "dispName"},
"challenge": "myChallenge",
"timeout": 1234567890,
"attestation": "myAttestation",
"optionId": "myOptionId"
}
}
"""
    }

    @PostMapping("/v1/registration/verify", produces = ["application/json; charset=UTF-8"])
    @ResponseBody
    fun dummyVerifyRegistration(): String {
        return """
            {
            "result": {
                "retCode":"S00000"
            },
            "retData": {
                "credentialId":"credentialId",
                "userKey":"userKey",
                "ktId":"ktId"
            }
            }
        """.trimIndent()
    }

    @PostMapping("v1/authentication/options", produces = ["application/json; charset=UTF-8"])
    @ResponseBody
    fun dummyReadyAuthentication(): String {
        return """
            {
                "result": {
                    "retCode":"S00000"
                },
                "retData": {
                    "rpId":"rpId",
                    "challenge":"challenge",
                    "timeout": 1234567890,
                    "optionId":"optionId",
                    "allowCredentials":[
                        {"type":"", "credentialId":"", "transports":  [""]  }
                    ],
                    "userVerification":"userVerification",
                    "attestation":"none"
                }
            }
        """.trimIndent()
    }

    @PostMapping("/v1/authentication/verify", produces = ["application/json; charset=UTF-8"])
    @ResponseBody
    fun dummyVerifyAuthentication(): String {
        return """
            {
                "result": {
                    "retCode":"S00000"
                },
                "retData": {
                    "scapToken":"scapTokenTest"
                }
            }
        """.trimIndent()
    }

    @PostMapping("/v1/passkey/info/userkey", produces = ["application/json; charset=UTF-8"])
    @ResponseBody
    fun dummyGetPasskeyInfo(
            @RequestBody test: TestDto?
    ): String {
        println("${test}, ${myService.test()}")
        return """
            {
                "result": {
                    "retCode":"S00000"
                },
                "retData": {
                    "credentialList": [
                        {
                             "credentialId":"credentialId1", 
                             "regDt":"2024.04.18 16:08", 
                             "authDt":"2024.04.18 16:08", 
                             "os":"iOS", 
                             "platform":"APPLE"
                         },
                         {
                             "credentialId":"credentialId2", 
                             "regDt":"2024.04.17 16:08", 
                             "authDt":"2024.04.17 16:08", 
                             "os":"AOS", 
                             "platform":"GOOGLE"
                         },
                         {
                             "credentialId":"credentialId3", 
                             "regDt":"2024.04.16 16:08", 
                             "authDt":"2024.04.16 16:08", 
                             "os":"AOS", 
                             "platform":"SAMSUNG"
                         }
                    ]
                }
            }
        """.trimIndent()
    }

    @PostMapping("/v1/passkey/delete/userkey", produces = ["application/json; charset=UTF-8"])
    @ResponseBody
    fun dummyDeletePasskeyInfo(): String {
        return """
            {
                "result": {
                    "retCode":"S00000"
                }
            }
        """.trimIndent()
    }
}