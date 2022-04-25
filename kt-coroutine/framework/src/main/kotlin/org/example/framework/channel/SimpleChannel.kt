package org.example.framework.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *@author ZhiQiang Tu
 *@time 2022/3/28  18:22
 *@signature 我将追寻并获取我想要的答案
 */

fun main(): Unit = runBlocking {
    val channel = Channel<Int>()
    launch {
        repeat(5) {
            channel.send(it)
        }
    }

    repeat(5) { println(channel.receive()) }

}

