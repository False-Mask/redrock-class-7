package org.example.framework.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

/**
 *@author ZhiQiang Tu
 *@time 2022/3/27  15:55
 *@signature 我将追寻并获取我想要的答案
 */

@OptIn(ExperimentalTime::class)
suspend fun main() {
    val x = measureTime {
        flowBuffer()
            .buffer()
            .onEach {  }
            .map { delay(3000) }
            //.flowOn(S)
            .collect {
                println("collect")
            }
    }
    println(x)
}

fun flowBuffer() = flow<Unit> {
    repeat(3){
        delay(1000)
        println("emit")
        emit(Unit)
    }
}

