package com.rosy.loctraceapplication.Util

import com.rosy.loctraceapplication.Util.JSON.Companion.toJsonObject
import com.rosy.loctraceapplication.Util.JSON.Companion.toJsonString
import kotlin.reflect.KClass

class Response {
    companion object {
        fun <T : Any> data(str: String, kotlinClass: KClass<T>): T {
           return JSON.toObject(jsonString = JSON.toJsonString(str.toJsonObject().get("data")), kotlinClass = kotlinClass)
        }

        fun <T : Any> dataList(str: String, kotlinClass: KClass<T>): List<T> {
            return JSON.toList(jsonString = JSON.toJsonString(str.toJsonObject().get("data")), kotlinClass = kotlinClass)
        }
    }
}