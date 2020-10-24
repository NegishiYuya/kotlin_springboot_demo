package com.example.demo.service

import com.example.demo.model.UserData

interface UserService {
    fun getUserList(): List<UserData>
    fun getUser(id: Int): UserData?
}