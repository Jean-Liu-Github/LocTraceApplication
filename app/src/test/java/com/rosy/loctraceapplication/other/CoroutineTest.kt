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
    fun test_dispatcher(): Unit = runBlocking {
        launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
            println("Unconfined      : I'm working in thread ${Thread.currentThread().name}")
            delay(500)
            println("Unconfined      : After delay in thread ${Thread.currentThread().name}")
        }
        launch { // context of the parent, main runBlocking coroutine
            println("main runBlocking: I'm working in thread ${Thread.currentThread().name}")
            delay(1000)
            println("main runBlocking: After delay in thread ${Thread.currentThread().name}")
        }
    }
}