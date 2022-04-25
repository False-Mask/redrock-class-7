package org.example.framework.channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consume
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 *@author ZhiQiang Tu
 *@time 2022/3/28  20:35
 *@signature 我将追寻并获取我想要的答案
 */
suspend fun main() {
    sendAndClose()
}

suspend fun sendAndClose() = coroutineScope {
    val channel = Channel<Int>()
    launch {
        repeat(10) {
            channel.send(it)
        }
        channel.close()
    }

    for (element in channel){
        println(element)
    }

    channel.consumeEach {

    }

    channel.consume {

    }

    channel.consumeAsFlow()
        .onEach {  }
        .map {  }
}




