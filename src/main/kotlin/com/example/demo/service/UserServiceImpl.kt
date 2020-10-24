package com.example.demo.service

import com.example.demo.model.UserData
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    override fun getUserList(): List<UserData> {
        return buildUserList()
    }

    override fun getUser(id: Int): UserData? {
        return buildUserList().find { id == it.id } ?: null
    }

    private fun buildUserList(): List<UserData> {
        return listOf(
                UserData(name = "太郎", id = 1),
                UserData(name = "花子", id = 2),
                UserData(name = "三郎", id = 3)
        )
    }
}