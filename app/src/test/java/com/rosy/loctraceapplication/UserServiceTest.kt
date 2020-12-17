package com.rosy.loctraceapplication

import android.view.ViewDebug
import com.rosy.loctraceapplication.Client.Client
import org.junit.Test

class UserServiceTest {
    @Test
    fun test_save_user() {
        Client.handleUser.saveUser("Jean Liu")
    }

    @Test
    fun test_get_register_users() {
        println(Client.handleUser.getRegisteUser())
    }
}