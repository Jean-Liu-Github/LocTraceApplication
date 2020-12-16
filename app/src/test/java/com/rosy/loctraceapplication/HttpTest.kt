package com.rosy.loctraceapplication

import com.rosy.loctraceapplication.Util.HttpConnection
import com.rosy.loctraceapplication.Util.JSON
import com.rosy.loctraceapplication.Util.JSON.Companion.toJsonObject
import com.rosy.loctraceapplication.Util.Response
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
        val user2 = UserLocation(user = User(id = 2, name = "Yang"), location = Location(latitude = 600.0, longitude = 800.0, now = LocalDateTime.now()))
        println(HttpConnection.postRequest(url, JSON.toJsonString(user2)))
    }
}