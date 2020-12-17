package com.rosy.loctraceapplication.Service.LocationService

import com.rosy.loctraceapplication.Service.UserService.GET_REGISTER_USERS
import com.rosy.loctraceapplication.Util.HttpConnection
import com.rosy.loctraceapplication.data.location.UserLocation
import com.rosy.loctraceapplication.data.user.User

class HandleLocationImpl : HandleLocation {
    override fun getUserLocation(user_ids: List<Int>): List<UserLocation> {
        TODO("Not yet implemented")
    }

    override fun updateMyLocation() {
        TODO("Not yet implemented")
    }
}