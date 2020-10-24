package com.example.demo.controller

import com.example.demo.model.UserData
import com.example.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * ユーザーに関するControllerクラス.
 * jsonを返す(WebAPI)を想定しているため、RestControllerアノテーションを付与する.
 * https://qiita.com/tag1216/items/3680b92cf96eb5a170f0
 *
 * RequestMappingアノテーションを付与して、リクエスト URL に対してどのクラス・メソッドを実行するか定義する.
 * https://www.shookuro.com/entry/2016/08/21/134349
 * https://qiita.com/TEBASAKI/items/267c261db17f178e33eb#requestmapping
 *
 * https://localhost:8080/user/(.+)
 * のアクセス時にこのクラスのメソッドが実行される.
 */
@RestController
@RequestMapping("user")
class UserController {

    /**
     * DIによってDIコンテナからインスタンスが注入される.
     * DIによって値を注入するため変数にはAutowiredアノテーションと lateinit(遅延初期化)をつける.
     */
    @Autowired
    lateinit var userService: UserService

    /**
     * GetMappingでリクエスト URL に対してどのメソッドを実行するか定義する.
     * https://localhost:8080/user/{id}
     * でのアクセスの場合、下記のメソッドが実行される.
     * {id}はパスパラメータと呼ばれる.
     *
     * パスパラメータで指定されたIDのユーザー情報を返却する.
     * https://qiita.com/MizoguchiKenji/items/2a041f3a3eb13274e55c
     */
    @GetMapping("/{id}")
    fun getUser(@PathVariable("id") id: Int): UserData? {
        return userService.getUser(id)
    }

    /**
     * https://localhost:8080/user/
     * でのアクセスの場合、下記のメソッドが実行される.
     */
    @GetMapping("")
    fun getUser(): List<UserData> {
        return userService.getUserList()
    }
}