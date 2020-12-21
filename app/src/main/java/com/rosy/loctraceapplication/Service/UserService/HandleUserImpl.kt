package com.rosy.loctraceapplication.Service.UserService

import com.rosy.loctraceapplication.Util.File
import com.rosy.loctraceapplication.Util.HttpConnection
import com.rosy.loctraceapplication.Util.JSON
import com.rosy.loctraceapplication.Util.JSON.getData
import com.rosy.loctraceapplication.Util.JSON.toJsonObject
import com.rosy.loctraceapplication.Util.Response
import com.rosy.loctraceapplication.data.user.User
import org.json.JSONObject
import java.net.HttpCookie

class HandleUserImpl : HandleUser {
    val filePath = "D:\\\\user\\"
    val fileName = "info.txt"
    override fun saveUser(name: String) {
        File.write(
                info = HttpConnection.postRequest(SAVE_USER, JSON.toJsonString(User(name = name)))
                        .getData(User::class),
                filePath = filePath,
                fileName = fileName,
        )
    }

    override fun getRegisteUser(): List<User> {
        return Response.dataList(HttpConnection.getRequest(GET_REGISTER_USERS), User::class)
    }
}