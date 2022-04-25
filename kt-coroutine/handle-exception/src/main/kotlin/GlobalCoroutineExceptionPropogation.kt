import kotlinx.coroutines.*

suspend fun main() {

    val scope = CoroutineScope(Dispatchers.IO)

    val job1 = scope.launch {
        async {
            throw Exception("A")
        }
    }
    job1.join()
}