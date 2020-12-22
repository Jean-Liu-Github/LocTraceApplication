package com.rosy.loctraceapplication.util

import java.io.File
import java.io.RandomAccessFile
import kotlin.reflect.KClass

object File {
    fun <T> write(info: T, filePath: String, fileName: String) {
        /** 生成文件夹 **/
        var path = File(filePath).apply { if (!exists()) { mkdir() } }
        /** 生成文件 **/
        val file = File(filePath + fileName).apply { if (!exists()) { createNewFile() } }
        /** 从新的一行插入 **/
        val infoStr = JSON.toJsonString(info) + "\r\n"
        /** 插入数据 **/
        RandomAccessFile(file, "rwd").let {
            it.seek(file.length())
            it.write(infoStr.toByteArray())
            it.close()
        }
    }

    fun <T : Any> read(filePath: String, fileName: String, kotlinClass: KClass<T>): T? {
        val file = File(filePath + fileName)

        if (!file.exists()) {
            return null
        }

        var jsonStr = ""
        RandomAccessFile(file, "rwd").let {
            it.seek(file.length())
            jsonStr = it.readLine()
            it.close()
        }

        return JSON.toObject(jsonString = jsonStr, kotlinClass)
    }
}