import kotlinx.coroutines.*

suspend fun main(): Unit {

    val scope = CoroutineScope(Dispatchers.IO)
    scope.launch(CoroutineExceptionHandler { coroutineContext, throwable -> println("catch:  $throwable") }) {
        launch {
            throw Exception("AA")
        }
    }

    delay(3000)

}

