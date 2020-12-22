package com.rosy.loctraceapplication.other

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.Test

class CoroutineTest {
    @Test
    fun hello_world() {
        GlobalScope.launch {
            delay(1000L)
            print("world!")
        }
        print("hello ")
        Thread.sleep(2000L)
    }
}