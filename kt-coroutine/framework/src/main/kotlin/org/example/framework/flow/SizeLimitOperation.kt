package org.example.framework.flow

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take

/**
 *@author ZhiQiang Tu
 *@time 2022/3/23  11:13
 *@signature 我将追寻并获取我想要的答案
 */
suspend fun main(){
    takeOperation()
        .take(10)
        .collect{
            println(it)
        }
}

fun takeOperation() = flow<Int> {
    repeat(1000){
        emit(it)
    }
}