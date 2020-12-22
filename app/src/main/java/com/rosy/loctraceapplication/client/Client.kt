package com.rosy.loctraceapplication.client

import com.rosy.loctraceapplication.service.LocationService.HandleLocationImpl
import com.rosy.loctraceapplication.service.UserService.HandleUserImpl

object Client {
    val handleUser = HandleUserImpl()
    val handleLocation = HandleLocationImpl()
}