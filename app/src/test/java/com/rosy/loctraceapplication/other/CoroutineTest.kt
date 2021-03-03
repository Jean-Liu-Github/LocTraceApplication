package com.rosy.loctraceapplication.other

import kotlinx.coroutines.*
import kotlin.concurrent.thread
import org.junit.Test
import java.lang.Thread.sleep
import java.util.concurrent.atomic.AtomicLong

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
    fun hello_world_join() = runBlocking<Unit> {
        val job = GlobalScope.launch {
            delay(1000L)
            print("world!")
        }
        print("hello ")
        job.join()
    }

    @Test
    fun hello_world_join2() = runBlocking<Unit> {
        val job = GlobalScope.launch {
            delay(1000L)
            print("world!")
        }
        print("hello ")
        job.start()
    }

    @Test
    fun light_weight() {
        val c = AtomicLong()

        for (i in 1..1_000_000L)
            GlobalScope.launch {
                c.addAndGet(i)
            }
        // coroutine 未全部完成
        println(c.get())
    }

    @Test
    fun light_weight2() = runBlocking {
        val deferred = (1..1_000_000L).map {
            GlobalScope.async {
                it
            }
        }
        val sum = deferred.sumOf { it.await().toLong() }
        print("Sum: $sum")
    }

    @Test
    fun testMySuspendFunction() = runBlocking<Unit> {

    }
}