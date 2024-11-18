package com.server.woody.woody.servlet

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "helloServlet", urlPatterns = ["/helloServlet"])
class HelloServlet: HttpServlet() {

    override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
//        super.service(req, resp)
        println("HelloServlet.serice")
        println("request = $req")
        println("request = $resp")

        resp?.contentType = "text/plain"
        resp?.characterEncoding = "utf-8"
        resp?.writer?.write("hello myName")
    }


}