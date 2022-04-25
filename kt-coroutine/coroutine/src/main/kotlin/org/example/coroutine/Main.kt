package org.example.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/3/19  14:21
 *@signature 我将追寻并获取我想要的答案
 */
fun main() {
    runBlocking {
        taskA()
        println("TaskA finished")
        taskB()
        println("TaskB finished")
        taskC()
    }
}