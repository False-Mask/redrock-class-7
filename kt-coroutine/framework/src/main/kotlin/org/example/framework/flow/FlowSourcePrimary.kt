package org.example.framework.flow

import kotlinx.coroutines.flow.*

/**
 *@author ZhiQiang Tu
 *@time 2022/3/23  16:32
 *@signature 我将追寻并获取我想要的答案
 */
suspend fun main() {
    flow {
        repeat(100) {
            emit(it)
        }
    }
        .map { it * it }
        .onEach {  }
        .map { it.toString() }
        .collect()
}


fun createOperation1() = (0..1).asFlow()

fun createOperation2() = flowOf(1, 2, 3)

fun createOperation3() = flow {
    repeat(100) {
        emit(it)
    }
}