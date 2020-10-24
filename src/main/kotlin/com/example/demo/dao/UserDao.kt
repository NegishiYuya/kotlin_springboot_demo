package com.example.demo.dao

import com.example.dbflute.exbhv.UserBhv
import com.example.dbflute.exentity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

/**
 * USERテーブルに関するDaoクラス.
 * Repositoryアノテーションを付与してDIコンテナへの登録対象とする.
 *
 * https://qiita.com/KevinFQ/items/abc7369cb07eb4b9ae29
 * https://note.com/yukoro/n/nf52f3fc60c17#td17S
 *
 * SELECTを行うDBFluteのメソッドは下記参照.
 * http://dbflute.seasar.org/ja/manual/function/ormapper/behavior/select/
 */
@Repository
class UserDao() {
    /**
     * USERテーブルのBehaviorクラスのオブジェクト.
     * DIによってDIコンテナからインスタンスが注入される.
     * DIによって値を注入するため変数にはAutowiredアノテーションと lateinit(遅延初期化)をつける.
     * http://dbflute.seasar.org/ja/manual/function/ormapper/behavior/about.html
     */
    @Autowired
    lateinit var userBhv: UserBhv

    /**
     * USERテーブルの全件をIDの昇順で取得する.
     */
    fun getUserList(): List<User> {
        /**
         * selectListを使ってListで取得する.
         * http://dbflute.seasar.org/ja/manual/function/ormapper/behavior/select/selectlist.html
         */
        return userBhv.selectList { it.query().addOrderBy_Id_Asc() }
    }

    /**
     * USERテーブルのうち、引数で渡したIDと一致するレコードを取得する.
     */
    fun getUser(id: Int): User {
        /**
         * selectEntityを使って1件取得する.
         * http://dbflute.seasar.org/ja/manual/function/ormapper/behavior/select/selectentity.html
         */
        return userBhv.selectEntity { it.query().setId_Equal(id) }.get()
    }
}