package com.rosy.loctraceapplication.service.LocationService

import com.rosy.loctraceapplication.data.location.UserLocation

interface HandleLocation {
    fun getUserLocation(user_ids: List<Int>): List<UserLocation>
    fun updateLocation(userLocation: UserLocation): Unit
    suspend fun updateLocationAsyns(userLocation: UserLocation)
}