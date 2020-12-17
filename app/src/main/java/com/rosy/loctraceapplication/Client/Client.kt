package com.rosy.loctraceapplication.Client

import com.rosy.loctraceapplication.Service.LocationService.HandleLocation
import com.rosy.loctraceapplication.Service.LocationService.HandleLocationImpl
import com.rosy.loctraceapplication.Service.UserService.HandleUser
import com.rosy.loctraceapplication.Service.UserService.HandleUserImpl

class Client {
    companion object {
        val handleUser = HandleUserImpl()
        val handleLocation = HandleLocationImpl()
    }
}