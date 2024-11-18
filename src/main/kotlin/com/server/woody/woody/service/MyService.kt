package com.server.woody.woody.service

import org.springframework.stereotype.Service

@Service
class MyService: BaseService {
    override fun test(): String {
        println("test: ${this::class.simpleName}")
        return "test function"
    }
}