package com.rosy.loctraceapplication.service.UserService

import com.rosy.loctraceapplication.data.user.User

interface HandleUser {
    fun saveUser(name: String): Unit
    fun getRegisterUser(): List<User>
    fun me(): User?
}