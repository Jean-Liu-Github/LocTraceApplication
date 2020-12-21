package com.rosy.loctraceapplication.data.location

import com.rosy.loctraceapplication.data.user.User
import java.io.Serializable

data class UserLocation(
    var user: User,
    var location: Location,
): Serializable