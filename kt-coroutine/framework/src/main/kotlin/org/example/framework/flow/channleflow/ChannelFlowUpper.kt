package org.example.framework.flow.channleflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.launch

fun <T> Flow<T>.merge(other: Flow<T>): Flow<T> = channelFlow {
    // collect from one coroutine and send it
    launch {
        collect { send(it) }
    }
    // collect and send from this coroutine, too, concurrently
    other.collect { send(it) }
}

/*
fun <T> contextualFlow(): Flow<T> = channelFlow {
    // send from one coroutine
    launch(Dispatchers.IO) {
        send(computeIoValue())
    }
    // send from another coroutine, concurrently
    launch(Dispatchers.Default) {
        send(computeCpuValue())
    }
}*/
