package org.example.framework.flow.channleflow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map

suspend fun main()  {
    val ch = channelFlow<Int> {
        repeat(10){
            delay(100)
            println(Thread.currentThread().name)
            send(it)
        }
    }.map {
        println("map ${Thread.currentThread().name}")
    }

    ch.collect()
    ch.collect()
    ch.collect()
    ch.collect()
    ch.collect()
    ch.collect()
    ch.collect()
    ch.collect()

}