package org.example.coroutine

import kotlinx.coroutines.delay

/**
 *@author ZhiQiang Tu
 *@time 2022/3/19  14:21
 *@signature 我将追寻并获取我想要的答案
 */
suspend fun taskA(){
    println("taskA:假装我在做耗时任务")
    delay(1000)
}

suspend fun taskB(){
    println("taskB:假装我在做耗时任务")
    delay(1000)
}

suspend fun taskC(){
    println("taskC:假装我在做耗时任务")
    delay(1000)
}