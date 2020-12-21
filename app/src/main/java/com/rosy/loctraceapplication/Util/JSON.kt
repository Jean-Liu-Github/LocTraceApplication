package com.rosy.loctraceapplication.Util

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import kotlin.reflect.KClass

object JSON {
    fun <T> toJsonString(obj: T): String {
        return JSON.toJSONString(obj)
    }

    fun <T : Any> toObject(jsonString: String, kotlinClass: KClass<T>): T {
        return JSON.parseObject(jsonString, kotlinClass.java)
    }

    fun <T : Any> toList(jsonString: String, kotlinClass:KClass<T>): List<T> {
        return JSON.parseArray(jsonString, kotlinClass.java)
    }

    fun String.toJsonObject(): JSONObject {
        return JSON.parseObject(this)
    }

    fun <T : Any> toObject(jsonObject: JSONObject, kotlinClass: KClass<T>): T {
        return JSON.parseObject(JSON.toJSONString(jsonObject), kotlinClass.java)
    }
}