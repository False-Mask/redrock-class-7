package org.example.framework.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

/**
 *@author ZhiQiang Tu
 *@time 2022/3/22  20:09
 *@signature 我将追寻并获取我想要的答案
 */
suspend fun main() {
    testFlow()
        .map {
            (it + 1).toString()
        }
        .collect {
            println(it)
        }
}

fun testFlow() = flow<Int> {
    repeat(100) {
        delay(1000)
        emit(it)
    }
}

fun flowBuilder1() = flow<Int> {
    repeat(1000) {
        emit(it)
    }
}

fun flowBuilder2() = (0..1).asFlow()

fun flowBuilder3() = flowOf(1,2,3,4,5)



