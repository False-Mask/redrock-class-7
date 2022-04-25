package org.example.framework

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


/**
 *@author ZhiQiang Tu
 *@time 2022/3/22  19:15
 *@signature 我将追寻并获取我想要的答案
 */

/*suspend fun main(): Unit {

    val x = GlobalScope.launch {
        println("b")
        delay(1000)
    }

    val y = GlobalScope.launch {
        println("b")
        delay(1000)
    }

    GlobalScope.cancel()


    Thread.sleep(10000)

}*/


suspend fun main() {

    var coroutineScope = CoroutineScope(Dispatchers.IO)
    /*coroutineScope.launch(SupervisorJob()) {
        //delay(2000)
        launch {
            while (true){
                delay(1000)
                println("B")
            }
        }
        launch {
            while (true){
                delay(2000)
                throw Exception("ww")
            }
        }
        //throw Exception("wowo!")
    }*/



    coroutineScope.launch(SupervisorJob()) {
        delay(2000)
        throw Exception("aa")
    }

    coroutineScope.launch {
        while (true) {
            delay(1000)
            println("A")
        }
    }

    supervisorScope {
        launch {

        }

        launch {

        }
    }


    CoroutineScope(CoroutineExceptionHandler{_,_->})

    delay(5000)
    println("i am alive")
}


/*suspend fun a():Int{
    delay(1000)
    return 1
}

fun v() = callbackFlow<Int> {
    send(a())
    close()
}


suspend fun main(){
    var launch = GlobalScope.launch {
        while (true){
            println("aaa")
            throw CancellationException("cancel")
        }
    }

    delay(1000)
    launch.cancel()
    launch.join()
}*/




