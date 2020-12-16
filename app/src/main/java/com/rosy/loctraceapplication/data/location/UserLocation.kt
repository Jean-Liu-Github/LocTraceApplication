package com.rosy.loctraceapplication.data.location

import com.rosy.loctraceapplication.data.user.User

data class UserLocation(
    var user: User,
    var location: Location,
)