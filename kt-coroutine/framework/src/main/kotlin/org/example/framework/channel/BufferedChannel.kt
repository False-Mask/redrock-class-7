package org.example.framework.channel

import kotlinx.coroutines.channels.Channel

/**
 *@author ZhiQiang Tu
 *@time 2022/3/29  10:59
 *@signature 我将追寻并获取我想要的答案
 */

suspend fun main() {
    bufferedChannel()

}

fun bufferedChannel() = Channel<Int>(capacity = 100)

