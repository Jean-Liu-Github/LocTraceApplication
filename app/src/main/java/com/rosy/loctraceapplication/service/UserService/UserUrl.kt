package com.rosy.loctraceapplication.service.UserService

const val HTTP = "http://"
const val HOST = "localhost"
const val PORT = "32000"
const val HTTP_HEAD = "$HTTP$HOST:$PORT"
const val USER_HEAD = "$HTTP_HEAD/loc-media/user"
const val SAVE_USER = "$USER_HEAD"
const val GET_REGISTER_USERS = "$USER_HEAD/all"