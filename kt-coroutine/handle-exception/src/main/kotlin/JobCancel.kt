import kotlinx.coroutines.*

suspend fun main() {

    val scope = CoroutineScope(Dispatchers.IO)
    scope.launch {

        launch {
            launch (SupervisorJob(coroutineContext[Job])  + CoroutineExceptionHandler { coroutineContext, throwable -> println(throwable) }){
                launch {
                    while (true) {
                        delay(1000)
                        println("A")
                    }
                }
                launch() {
                    throw Exception("Exception")
                }
            }

            launch {
                while (true) {
                    delay(1000)
                    println("C")
                }
            }
        }

    }

    scope.launch {
        while (true) {
            delay(1000)
            println("B")
        }
    }

    delay(1000000)

}
