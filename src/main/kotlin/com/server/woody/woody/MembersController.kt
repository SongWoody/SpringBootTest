package com.server.woody.woody

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class MembersController {

    @GetMapping("/create")
    fun create(): String {
        return "book/create"
    }
}