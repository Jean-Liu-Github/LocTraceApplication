package com.rosy.loctraceapplication.other

import kotlin.concurrent.thread
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.lang.Thread.sleep

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

    @Test
    fun hello_world2() {
        Thread {
            sleep(3000L)
            print("world!")
        }.start()
        print("hello ")
        Thread.sleep(2000L)
    }

    @Test
    fun hello_world_delay() {
        GlobalScope.launch {
            delay(1000L)
            print("world!")
        }
        print("hello ")
        runBlocking { delay(2000L) }
    }

    @Test
    fun hello_world_join() {
        val job = GlobalScope.launch {
            delay(1000L)
            print("world!")
        }
        print("hello ")
    }

    @Test
    fun testMySuspendFunction() = runBlocking<Unit> {

    }
}