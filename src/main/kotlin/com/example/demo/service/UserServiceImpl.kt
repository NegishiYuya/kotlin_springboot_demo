package com.example.demo.service

import com.example.demo.dao.UserDao
import com.example.demo.model.UserData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    lateinit var userDao: UserDao

    override fun getUserList(): List<UserData> {
        return userDao.getUserList()
    }

    override fun getUser(id: Int): UserData? {
        return userDao.getUser(id)
    }
}