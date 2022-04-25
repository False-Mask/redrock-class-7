package org.example.suspend

import kotlinx.coroutines.delay

/**
 *@author ZhiQiang Tu
 *@time 2022/3/19  22:22
 *@signature 我将追寻并获取我想要的答案
 */
fun main() {
    val suspendLambda = suspend {
        delay(1000)
    }
}