package com.rosy.loctraceapplication.Service.LocationService

import com.rosy.loctraceapplication.Util.HttpConnection
import com.rosy.loctraceapplication.data.location.UserLocation
import com.rosy.loctraceapplication.data.user.User

interface HandleLocation {
    fun getUserLocation(user_ids: List<Int>): List<UserLocation>
    fun updateMyLocation(): Unit
}