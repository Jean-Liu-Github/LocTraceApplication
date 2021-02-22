package com.rosy.loctraceapplication

import com.rosy.loctraceapplication.client.Client
import com.rosy.loctraceapplication.data.location.Location
import com.rosy.loctraceapplication.data.location.UserLocation
import com.rosy.loctraceapplication.data.user.User
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
    fun test_update_location_async() {
        println("main")
        var longitude = 868.0
        val job = GlobalScope.launch(Dispatchers.Default) {
            println("co start")
            val user2 = UserLocation(user = User(id = 2, name = "Yang"), location = Location(latitude = 600.0, longitude = longitude, now = LocalDateTime.now()))
            Client.handleLocation.updateLocationAsyns(user2)
            while (true) {
                longitude += 10.0
                val user2 = UserLocation(user = User(id = 2, name = "Yang"), location = Location(latitude = 600.0, longitude = longitude, now = LocalDateTime.now()))
                delay(5000)
                Client.handleLocation.updateLocationAsyns(user2)
                println(longitude)
            }
        }
        job.start()
        Thread.sleep(200000L)
        println("main end")
    }
}