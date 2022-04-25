package org.example.suspend

import kotlinx.coroutines.delay

/**
 *@author ZhiQiang Tu
 *@time 2022/3/20  17:04
 *@signature 我将追寻并获取我想要的答案
 */
suspend fun main() {
    test()
}

suspend fun test(){
    println("1")
    delay(1000)
    println("2")
    delay(1000)
    println("3")
    delay(1000)
    println("4")
    delay(1000)
    println("5")
    delay(1000)
}