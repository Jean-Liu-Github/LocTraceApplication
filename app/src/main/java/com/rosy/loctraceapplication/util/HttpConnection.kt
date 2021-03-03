package com.rosy.loctraceapplication.util

import java.net.HttpURLConnection
import java.net.URL

object HttpConnection {
    fun getHttpConnection(urlString: String): HttpURLConnection {
        val conn = URL(urlString).openConnection() as HttpURLConnection
//            //必须在协程上或非主线程上进行connect, 否则报错
//            conn.connect()
        return conn
    }

    fun getRequest(url: String): String {
        val resp: String
        val conn = getHttpConnection(url)
        conn.run {
            requestMethod = "GET"
            doInput = true
            doOutput = true
            useCaches = false
            setRequestProperty("Content-Type", "application/json;charset=UTF-8")
        }
        conn.inputStream.use {
            resp = it.bufferedReader().readText()
        }
        conn.disconnect()
        return resp
    }

    fun postRequest(url: String, jsonString: String): String {
        return requestAboutUpdate(url = url, method = "POST", jsonString = jsonString)
    }

    fun putRequest(url: String, jsonString: String): String {
        return requestAboutUpdate(url = url, method = "PUT", jsonString = jsonString)
    }

    fun patchReqeust(url: String, jsonString: String): String {
        return requestAboutUpdate(url = url, method = "PATCH", jsonString = jsonString)
    }

    private fun requestAboutUpdate(url: String, method: String, jsonString: String): String {
        val conn = getHttpConnection(url)
        conn.run {
            requestMethod = method
            doInput = true
            doOutput = true
            useCaches = false
            setRequestProperty("Content-Type", "application/json;charset=UTF-8")
        }

        conn.outputStream.run {
            write(jsonString.toByteArray(charset = Charsets.UTF_8))
            flush()
            close()
        }

        val inStream = if (conn.responseCode == 200)
            conn.inputStream
        else
            conn.errorStream

        val result = inStream.bufferedReader().readText()
        conn.disconnect()
        return result
    }
}