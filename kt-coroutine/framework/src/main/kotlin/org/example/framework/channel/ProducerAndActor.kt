package org.example.framework.channel

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.receiveAsFlow

/**
 *@author ZhiQiang Tu
 *@time 2022/3/28  21:24
 *@signature 我将追寻并获取我想要的答案
 */
fun CoroutineScope.produceSome() = produce<Int> {
    repeat(3) {
        delay(1000)
        send(it)
    }
}

suspend fun main(): Unit = coroutineScope {
    /*produceSome()
        .consumeAsFlow()
        .collect {
            println(Thread.currentThread().name)
        }*/

    repeat(10){
        launch {
            produceSome()
                .receiveAsFlow()
                .collect {
                    println(it)
                }
        }
    }


    /*with(consumeSome()){
        repeat(10){
            send(it)
            println(Thread.currentThread().name)
        }
    }*/


}


fun CoroutineScope.consumeSome() = actor<Int> {
    repeat(10) {
        delay(1000)
        val re = receive()
        println("${Thread.currentThread().name} $re")
    }
}




