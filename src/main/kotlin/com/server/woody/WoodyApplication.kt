package com.server.woody

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@ServletComponentScan
@SpringBootApplication
class WoodyApplication

fun main(args: Array<String>) {
	runApplication<WoodyApplication>(*args)
}
