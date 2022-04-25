import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main():Unit = coroutineScope {

    val job1 = launch {
        while (true){
            delay(1000)
            println("A")
        }
    }

    val job2 = launch {
        while (true){
            delay(1000)
            println("B")
        }
    }


    delay(1000)
    job1.cancel()

}