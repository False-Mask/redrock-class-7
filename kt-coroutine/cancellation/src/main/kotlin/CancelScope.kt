import kotlinx.coroutines.*

/*
suspend fun main() = coroutineScope {
    launch {
        while (true){
            delay(1000)
            println("A")
        }
    }

    launch {
        while (true){
            delay(1000)
            println("B")
        }
    }

    delay(5000)
    this.cancel()

    repeat(100){
        delay(1000)
        println(it)
    }
}*/


suspend fun main() {

var job:Job = Job()
    val scope = CoroutineScope(Dispatchers.IO).apply {


         job = launch {
            while (true){
                delay(1000)
                println("A")
            }
        }

        launch {
            while (true) {
                delay(1000)
                println("B")
            }
        }

    }


    job.cancel()
    delay(5000)

}


