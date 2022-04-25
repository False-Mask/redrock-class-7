import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

suspend fun main(): Unit {

    val scope = CoroutineScope(Dispatchers.IO)
    scope.launch {
        var job :Job = Job()
        println("job:$job")
        launch(job) {
            println(coroutineContext[Job]!!.job)
        }
    }

    delay(1000)

}


