package com.rosy.loctraceapplication.Service.UserService

import com.rosy.loctraceapplication.Util.HttpConnection
import com.rosy.loctraceapplication.Util.JSON
import com.rosy.loctraceapplication.Util.Response
import com.rosy.loctraceapplication.data.user.User

class HandleUserImpl : HandleUser {
    override fun saveUser(name: String) {
        HttpConnection.postRequest(SAVE_USER, JSON.toJsonString(User(name = name)))
    }

    override fun getRegisteUser(): List<User> {
        return Response.dataList(HttpConnection.getRequest(GET_REGISTER_USERS), User::class)
    }
}