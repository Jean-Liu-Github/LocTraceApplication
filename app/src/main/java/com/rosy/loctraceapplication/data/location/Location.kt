package com.rosy.loctraceapplication.data.location

import java.io.Serializable
import java.time.LocalDateTime

data class Location(
    var longitude: Double,
    var latitude: Double,
    var now: LocalDateTime
): Serializable