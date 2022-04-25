package org.example.framework.flow.callbackflow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect

suspend fun main() {
    val ch = callbackFlow<Int> {
        repeat(10){
            delay(100)
            println(Thread.currentThread().name)
            send(it)
        }
    }

    ch.collect()
    ch.collect()

}