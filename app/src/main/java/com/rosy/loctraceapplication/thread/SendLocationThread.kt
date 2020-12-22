package com.rosy.loctraceapplication.thread

import android.os.Build
import androidx.annotation.RequiresApi
import com.rosy.loctraceapplication.client.Client
import com.rosy.loctraceapplication.data.location.Location
import com.rosy.loctraceapplication.data.location.UserLocation
import java.time.LocalDateTime

class SendLocationThread: Thread() {
    override fun run() {
        super.run()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun sendLocation() {
        //getMyLocationByMap
        val myLocation = Location(
                longitude = 100.0,
                latitude = 200.0,
                now = LocalDateTime.now()
        )

        Client.handleLocation.updateLocation(UserLocation(
               user = Client.handleUser.me(),
               location = myLocation
        ))
    }
}