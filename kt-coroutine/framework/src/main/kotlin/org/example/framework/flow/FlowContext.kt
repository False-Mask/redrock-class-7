package org.example.framework.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 *@author ZhiQiang Tu
 *@time 2022/3/23  12:42
 *@signature 我将追寻并获取我想要的答案
 */

suspend fun main() {


    flow<Int> {
        repeat(100) {
            delay(5000)
            println("emit ${Thread.currentThread().name}")
            emit(it)
        }
    }
        .launchIn(CoroutineScope(newSingleThreadContext("a")))

}

suspend fun flowOnOperator() = flowContext()
    .flowOn(newSingleThreadContext("a"))
    .map {
        delay(5000)
        println("map1 ${Thread.currentThread().name}")
    }
    .flowOn(newSingleThreadContext("b"))
    .map {
        delay(5000)
        println("map2 ${Thread.currentThread().name}")
    }
    .flowOn(newSingleThreadContext("c"))
    .collect()

fun flowContext() = flow<Int> {
    repeat(100) {
        delay(5000)
        println("emit ${Thread.currentThread().name}")
        emit(it)
    }
}





