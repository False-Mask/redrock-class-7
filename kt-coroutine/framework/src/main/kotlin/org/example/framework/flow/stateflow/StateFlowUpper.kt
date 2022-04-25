package org.example.framework.flow.stateflow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


suspend fun main() {
    val stateFlow = MutableStateFlow(1)
    stateFlow
        .onEach {
            println("${Thread.currentThread().name}:$it")
        }
        .launchIn(CoroutineScope(Dispatchers.IO))


    stateFlow
        .onEach {
            println("${Thread.currentThread().name}:$it")
        }.launchIn(CoroutineScope(Dispatchers.Default))

    delay(2000)
    stateFlow.value = 10
    delay(1000)
    stateFlow.value = 100
    Thread.sleep(10000000)

}
