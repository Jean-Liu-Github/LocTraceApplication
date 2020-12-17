package com.rosy.loctraceapplication.Service.UserService

import com.rosy.loctraceapplication.data.user.User

interface HandleUser {
    fun saveUser(name: String): Unit
    fun getRegisteUser(): List<User>
}