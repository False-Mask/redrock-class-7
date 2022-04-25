package org.example.suspend

import kotlinx.coroutines.*

/**
 *@author ZhiQiang Tu
 *@time 2022/3/19  20:37
 *@signature 我将追寻并获取我想要的答案
 */
suspend fun main() {
    suspendFuc()
}

suspend fun suspendFuc(){
    println("这是一个挂起函数")
    delay(1000)
    println("挂起函数被挂起了")
    delay(1000)
    println("挂起函数被挂起了")
    delay(1000)
    println("挂起函数被挂起了")
    delay(1000)
    println("挂起函数被挂起了")
}

