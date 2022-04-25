import kotlinx.coroutines.*

fun main():Unit = runBlocking {

    val job = launch (Dispatchers.IO){
        while (true) {
            println("A")
            Thread.sleep(1000)
        }
    }

    delay(1000)
    job.cancelAndJoin()

}

