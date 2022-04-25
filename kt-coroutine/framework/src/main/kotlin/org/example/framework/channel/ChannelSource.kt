package org.example.framework.channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.*

/**
 *@author ZhiQiang Tu
 *@time 2022/3/29  11:13
 *@signature 我将追寻并获取我想要的答案
 */

val channel = Channel<Int>()

suspend fun main():Unit = coroutineScope{
    /*launch {
        repeat(10) {
            println("send $it")
            channel.send(it)
            delay(1000)
        }
    }*/

    val ch = produce<Int> {
        repeat(10) {
            println("send $it")
            channel.send(it)
            delay(1000)
        }
    }

    /*repeat(10){
        channel.receive()
        println("receive $it")
    }*/


    with(CoroutineScope(Dispatchers.IO)){
        launch {
            channel.receiveAsFlow()
            .map {
                println("receive1 $it")
            }.collect()
        }
        launch {
            channel.receiveAsFlow()
                .map {
                    println("receive2 $it")
                }.collect()
        }
    }



}



