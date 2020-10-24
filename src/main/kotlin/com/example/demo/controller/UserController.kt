package com.example.demo.controller

import com.example.demo.model.UserData
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserController {
    val userList = listOf(
            UserData(name = "太郎", id = 1),
            UserData(name = "花子", id = 2)
    )

    @GetMapping("/{id}")
    fun getUser(@PathVariable("id") id: Int): UserData? {
        return userList.find { it.id == id } ?: null
    }

    @GetMapping("")
    fun getUser(): List<UserData> {
        return userList
    }
}