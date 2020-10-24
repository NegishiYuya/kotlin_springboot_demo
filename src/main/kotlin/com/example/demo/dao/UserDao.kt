package com.example.demo.dao

import com.example.demo.model.UserData
import org.springframework.stereotype.Repository

@Repository
class UserDao {
    fun getUserList(): List<UserData> {
        return buildUserList()
    }

    fun getUser(id: Int): UserData? {
        return buildUserList().find { id == it.id }
    }

    private fun buildUserList(): List<UserData> {
        return listOf(
                UserData(name = "太郎", id = 1),
                UserData(name = "花子", id = 2),
                UserData(name = "三郎", id = 3),
                UserData(name = "四郎", id = 4)
        )
    }
}