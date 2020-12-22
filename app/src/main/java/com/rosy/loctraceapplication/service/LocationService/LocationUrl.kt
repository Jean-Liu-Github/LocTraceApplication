package com.rosy.loctraceapplication.service.LocationService

const val HTTP = "http://"
const val HOST = "localhost"
const val PORT = "32000"
const val HTTP_HEAD = "$HTTP$HOST:$PORT"
const val LOCATION_HEAD = "$HTTP_HEAD/loc-media"
const val GET_LOCATION = "$LOCATION_HEAD/user/location/one"
const val GET_LOCATIONS = "$LOCATION_HEAD/user/location/list"
const val SAVE_LOCATION = "$LOCATION_HEAD/user/location"