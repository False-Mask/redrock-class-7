package org.example.framework.flow.sharedflow

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

suspend fun main() = runBlocking{
    val sharedFlow = MutableSharedFlow<Int>(onBufferOverflow = BufferOverflow.DROP_LATEST)

    sharedFlow
        .onEach {
            println("A:$it")
        }
        .launchIn(this)

    sharedFlow
        .onEach {
            delay(1000)
            println("B:$it")
        }
        .launchIn(this)

    repeat(1000){
        delay(1)
        sharedFlow.emit(it)
    }

}