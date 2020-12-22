package com.rosy.loctraceapplication

import com.rosy.loctraceapplication.client.Client
import org.junit.Test

class UserServiceTest {
    @Test
    fun test_save_user() {
        Client.handleUser.saveUser("Jean Liu")
    }

    @Test
    fun test_get_register_users() {
        println(Client.handleUser.getRegisterUser())
    }
}