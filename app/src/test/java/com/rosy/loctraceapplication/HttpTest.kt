package com.rosy.loctraceapplication

import com.rosy.loctraceapplication.util.HttpConnection
import com.rosy.loctraceapplication.util.JSON
import com.rosy.loctraceapplication.util.Response
import com.rosy.loctraceapplication.data.location.Location
import com.rosy.loctraceapplication.data.location.UserLocation
import com.rosy.loctraceapplication.data.user.User
import org.junit.Test
import java.time.LocalDateTime

class HttpTest {
    @Test
    fun http_get_method() {
        val url = "http://localhost:32000/loc-media/user/location/list?user_ids=1,2"
        println(Response.dataList(HttpConnection.getRequest(url), UserLocation::class))
    }

    @Test
    fun http_post_method() {
        val url = "http://localhost:32000/loc-media/user/location"
        val user2 = UserLocation(user = User(id = 2, name = "Yang"), location = Location(latitude = 600.0, longitude = 868.0, now = LocalDateTime.now()))
        println(HttpConnection.putRequest(url, JSON.toJsonString(user2)))
    }
}