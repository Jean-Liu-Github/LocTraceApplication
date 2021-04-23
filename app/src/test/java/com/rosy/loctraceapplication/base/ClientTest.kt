package com.rosy.loctraceapplication.base

import com.rosy.loctraceapplication.client.Client
import com.rosy.loctraceapplication.data.location.Location
import com.rosy.loctraceapplication.data.location.UserLocation
import com.rosy.loctraceapplication.data.user.User
import kotlinx.coroutines.*
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import java.time.LocalDateTime

@OptIn(ExperimentalCoroutinesApi::class)
class ClientTest {


    @Test
    fun test_update_location_async() = runBlockingTest {
        println("update location start")
        var longitude = 868.0
        launch {
            println("co start")
            var user2 = UserLocation(user = User(id = 2, name = "Yang"), location = Location(latitude = 600.0, longitude = longitude, now = LocalDateTime.now()))
            user2.allow = true
            Client.handleLocation.updateLocationAsyns(user2)
            while (true) {
                longitude += 10.0
                user2 = UserLocation(user = User(id = 2, name = "Yang"), location = Location(latitude = 600.0, longitude = longitude, now = LocalDateTime.now()))
                user2.allow = true
                delay(5000)
                Client.handleLocation.updateLocationAsyns(user2)
                println(longitude)
            }
        }
        launch {
            var user1 = UserLocation(user=User(id = 1, name = "Jean Liu"), location = Location(6.0,8.0, LocalDateTime.now()))
            user1.allow = true
            Client.handleLocation.updateLocationAsyns(user1)
        }
        println("update location end")
    }
}