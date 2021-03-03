package com.rosy.loctraceapplication.service.LocationService

import android.os.Build
import androidx.annotation.RequiresApi
import com.rosy.loctraceapplication.client.Client
import com.rosy.loctraceapplication.util.HttpConnection
import com.rosy.loctraceapplication.util.JSON
import com.rosy.loctraceapplication.data.location.Location
import com.rosy.loctraceapplication.data.location.UserLocation
import com.rosy.loctraceapplication.util.Response
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
class HandleLocationImpl : HandleLocation {

    override fun getUserLocation(user_ids: List<Int>): List<UserLocation> {
        return Response.dataList(HttpConnection.getRequest("${GET_LOCATIONS}?user_ids=${user_ids.toString().trim('[', ']').replace(" ", "")}"), UserLocation::class)
    }

    override fun updateLocation(userLocation: UserLocation) {
        HttpConnection.putRequest(SAVE_LOCATION, JSON.toJsonString(userLocation))
    }

    override suspend fun updateLocationAsyns(userLocation: UserLocation) {
        HttpConnection.putRequest(SAVE_LOCATION, JSON.toJsonString(userLocation))
    }

    private fun myNowLocation(): UserLocation {
        return UserLocation(user = Client.handleUser.me(), location = getMyLocationByMap())
    }


    private fun getMyLocationByMap(): Location {
        return Location(longitude = 200.0, latitude = 300.0, now = LocalDateTime.now())
    }
}