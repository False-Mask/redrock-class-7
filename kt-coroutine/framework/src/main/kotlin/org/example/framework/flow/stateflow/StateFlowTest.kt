package org.example.framework.flow.stateflow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

suspend fun main() {

    val stateFlow = MutableStateFlow(1)

    stateFlow
        .onEach {
            println(it)
        }
        .launchIn(CoroutineScope(Dispatchers.IO))



    repeat(100){
        delay(1000)
        stateFlow.value = it
    }

}