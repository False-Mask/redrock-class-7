package org.example.framework.flow

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

/**
 *@author ZhiQiang Tu
 *@time 2022/3/24  15:54
 *@signature 我将追寻并获取我想要的答案
 */
suspend fun main() {
    contextSwitchFlow()
        .map {
            println("map1: ${Thread.currentThread().name}")
        }
        .map {
            println("map2: ${Thread.currentThread().name}")
        }
        .flowOn(Dispatchers.IO)
        .map {
            println("map3: ${Thread.currentThread().name}")
        }
        .map {
            println("map4: ${Thread.currentThread().name}")
        }
        .flowOn(Dispatchers.Default)
        .collect()

}


fun contextSwitchFlow() = flow {
    repeat(10){
        emit(Unit)
    }
}



