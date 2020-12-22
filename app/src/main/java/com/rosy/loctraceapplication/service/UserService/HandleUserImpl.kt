package com.rosy.loctraceapplication.service.UserService

import com.rosy.loctraceapplication.util.File
import com.rosy.loctraceapplication.util.HttpConnection
import com.rosy.loctraceapplication.util.JSON
import com.rosy.loctraceapplication.util.JSON.getData
import com.rosy.loctraceapplication.util.Response
import com.rosy.loctraceapplication.data.user.User
import com.rosy.loctraceapplication.exception.BusinessException

class HandleUserImpl : HandleUser {
    private val filePath = "D:\\\\user\\"
    private val fileName = "info.txt"
    override fun saveUser(name: String) {
        File.write(
                info = HttpConnection.postRequest(SAVE_USER, JSON.toJsonString(User(name = name)))
                        .getData(User::class),
                filePath = filePath,
                fileName = fileName,
        )
    }

    override fun getRegisterUser(): List<User> {
        return Response.dataList(HttpConnection.getRequest(GET_REGISTER_USERS), User::class)
    }

    override fun me(): User {
        return File.read(
                filePath = filePath,
                fileName = fileName,
                User::class
        ) ?: throw BusinessException()
    }
}