import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main() :Unit = runBlocking {
    val job = launch {
        try {
            delay(10000000)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    delay(1000)
    job.cancel()
}
