package com.rosy.loctraceapplication

import com.rosy.loctraceapplication.client.Client
import com.rosy.loctraceapplication.data.location.Location
import com.rosy.loctraceapplication.data.location.UserLocation
import com.rosy.loctraceapplication.data.user.User
import com.rosy.loctraceapplication.util.JSON
import com.rosy.loctraceapplication.util.Response
import kotlinx.coroutines.*
import org.junit.Test
import java.time.LocalDateTime

class LocationServiceTest {
    @Test
    fun test_update_location() {
        val user2 = UserLocation(user = User(id = 2, name = "Yang"), location = Location(latitude = 600.0, longitude = 868.0, now = LocalDateTime.now()))
        Client.handleLocation.updateLocation(user2)
    }

    @Test
    fun get_user_locations() {
        println(JSON.toJsonString(Client.handleLocation.getUserLocation(listOf(1,2,3))))
    }
}