package com.rosy.loctraceapplication.Service.LocationService

import android.os.Build
import androidx.annotation.RequiresApi
import com.rosy.loctraceapplication.Client.Client
import com.rosy.loctraceapplication.Service.UserService.GET_REGISTER_USERS
import com.rosy.loctraceapplication.Service.UserService.HandleUser
import com.rosy.loctraceapplication.Util.HttpConnection
import com.rosy.loctraceapplication.Util.JSON
import com.rosy.loctraceapplication.data.location.Location
import com.rosy.loctraceapplication.data.location.UserLocation
import com.rosy.loctraceapplication.data.user.User
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
class HandleLocationImpl : HandleLocation {

    override fun getUserLocation(user_ids: List<Int>): List<UserLocation> {
        TODO("Not yet implemented")
    }

    override fun updateMyLocation() {
        HttpConnection.putRequest(SAVE_LOCATION, JSON.toJsonString(myNowLocation()))
    }


    private fun myNowLocation(): UserLocation {
        return UserLocation(user = User(name = "j"), location = getMyLocationByMap())
    }


    private fun getMyLocationByMap(): Location {
        return Location(longitude = 200.0, latitude = 300.0, now = LocalDateTime.now())
    }
}