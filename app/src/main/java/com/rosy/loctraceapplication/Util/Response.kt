package com.rosy.loctraceapplication.Util

import com.rosy.loctraceapplication.Util.JSON.toJsonObject
import kotlin.reflect.KClass

object Response {
    fun <T : Any> data(str: String, kotlinClass: KClass<T>): T {
        return JSON.toObject(jsonString = JSON.toJsonString(str.toJsonObject().get("data")), kotlinClass = kotlinClass)
    }

    fun <T : Any> dataList(str: String, kotlinClass: KClass<T>): List<T> {
        return JSON.toList(jsonString = JSON.toJsonString(str.toJsonObject().get("data")), kotlinClass = kotlinClass)
    }
}