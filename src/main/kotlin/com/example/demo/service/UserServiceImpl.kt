package com.example.demo.service

import com.example.demo.dao.UserDao
import com.example.demo.model.UserData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * ユーザーに関するServiceクラス.
 * Serviceアノテーションを付与してDIコンテナへの登録対象とする.
 */
@Service
class UserServiceImpl : UserService {

    /**
     * DIによってDIコンテナからインスタンスが注入される.
     * DIによって値を注入するため変数にはAutowiredアノテーションと lateinit(遅延初期化)をつける.
     */
    @Autowired
    lateinit var userDao: UserDao

    /**
     * ユーザーのListを返却する.
     */
    override fun getUserList(): List<UserData> {
        // Daoから取得したUserのListからUserDataのListにmapメソッドを使って詰め替える
        return userDao.getUserList().map {
            UserData(id = it.id, name = it.name)
        }
    }

    /**
     * 引数に一致するユーザーの情報を返却する.
     */
    override fun getUser(id: Int): UserData? {
        val user = userDao.getUser(id)
        // Daoから取得したUserをUserDateに詰め替える
        return UserData(id = user.id, name = user.name)
    }
}