package com.example.demo.controller

import com.example.demo.model.UserData
import com.example.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserController {
    @Autowired
    lateinit var userService: UserService

    @GetMapping("/{id}")
    fun getUser(@PathVariable("id") id: Int): UserData? {
        return userService.getUser(id)
    }

    @GetMapping("")
    fun getUser(): List<UserData> {
        return userService.getUserList()
    }
}