package com.rosy.loctraceapplication.base

import com.rosy.loctraceapplication.util.File
import com.rosy.loctraceapplication.data.user.User
import org.junit.Test

class FileTest {
    @Test
    fun make_directory() {
        val user = User(id = 1, name = "Jean Liu")
        File.write(info = user, filePath = "D:\\\\test_file\\", fileName = "test.txt")
    }
}