package com.rosy.loctraceapplication.Util

import java.io.File
import java.io.RandomAccessFile

object File {
    fun <T> write(info: T, filePath: String, fileName: String) {
        /** 生成文件夹 **/
        var path = File(filePath).apply { if (!exists()) { mkdir() } }
        /** 生成文件 **/
        var file = File(filePath + fileName).apply { if (!exists()) { createNewFile() } }
        /** 从新的一行插入 **/
        val infoStr = JSON.toJsonString(info) + "\r\n"
        /** 插入数据 **/
        RandomAccessFile(file, "rwd").let {
            it.seek(file.length())
            it.write(infoStr.toByteArray())
            it.close()
        }
    }
}