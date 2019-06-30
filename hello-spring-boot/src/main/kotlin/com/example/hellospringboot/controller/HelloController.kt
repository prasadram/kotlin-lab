package com.example.hellospringboot.controller

import com.example.hellospringboot.model.CommonHeader
import com.example.hellospringboot.model.Hello
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @Autowired
    lateinit var commonHeader:CommonHeader

    @GetMapping("/hello")
    fun sayHello(@RequestParam(value = "name", defaultValue = "Kobbu") name: String
    ) = Hello(1, "Hello $name version ${commonHeader.getHeader("x-version")} ")
}