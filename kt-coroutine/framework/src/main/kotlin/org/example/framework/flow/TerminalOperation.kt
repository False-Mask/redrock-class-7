package org.example.framework.flow

import kotlinx.coroutines.flow.*

/**
 *@author ZhiQiang Tu
 *@time 2022/3/23  11:22
 *@signature 我将追寻并获取我想要的答案
 */
suspend fun main() {
//    terminalOperation()
//        .collect()
//
//    terminalOperation()
//        .toList()

//    terminalOperation()
//        .toSet()
//    terminalOperation()
//        .first()
//
//    terminalOperation()
//        .single()

    terminalOperation().reduce { accumulator, value ->
        accumulator + value
    }
    terminalOperation().fold(""){acc: String, value: Int ->
        acc + value.toString()
    }
}

fun terminalOperation() = flow<Int> {
    repeat(1000){
        emit(it)
    }
}

