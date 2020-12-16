package com.rosy.loctraceapplication.Util

import android.content.ContentValues.TAG
import android.util.Log
import java.net.HttpURLConnection
import java.net.URL

class HttpConnection {
    companion object {
        fun getHttpConnection(urlString: String): HttpURLConnection {
            val conn = URL(urlString).openConnection() as HttpURLConnection
//            conn.connect()
            return conn
        }

        fun getRequest(url: String): String {
            val resp: String
            val conn = getHttpConnection(url)
            conn.requestMethod = "GET"
            conn.inputStream.use {
                resp = it.bufferedReader().readText()
            }
            conn.disconnect()
            return resp
        }

        fun postRequest(url: String, jsonString: String): String {
            val conn = getHttpConnection(url)
            conn.requestMethod = "POST"
            conn.doOutput = true
            conn.doInput = true
            conn.useCaches = false
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8")

            // 向服务端发送请求参数
            conn.outputStream.let {
                it.write(jsonString.toByteArray(Charsets.UTF_8))
                it.flush()
                it.close()
            }

            // 从服务端获取响应码，连接成功是200
            val code = conn.responseCode
            // 根据响应码获取不同输入流
            val inStream = if (code == 200)
                conn.inputStream
            else
                conn.errorStream
            // 输入流转换成字符串
            val result = inStream.bufferedReader().readText()
            conn.disconnect() //断开连接
            return result
        }
    }
}