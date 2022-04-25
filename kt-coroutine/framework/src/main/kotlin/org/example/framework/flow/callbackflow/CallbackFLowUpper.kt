package org.example.framework.flow.callbackflow

import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.onFailure
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.coroutines.cancellation.CancellationException

fun <T> flowFrom(api: CallbackBasedApi<T>): Flow<T> = callbackFlow {
    val callback = object : Callback<T> { // Implementation of some callback interface
        override fun onNextValue(value: T) {
            // To avoid blocking you can configure channel capacity using
            // either buffer(Channel.CONFLATED) or buffer(Channel.UNLIMITED) to avoid overfill
            trySendBlocking(value).onFailure { throwable ->
                // Downstream has been cancelled or failed, can log here
            }
        }

        override fun onApiError(cause: Throwable) {
            cancel(CancellationException("API Error", cause))
        }

        override fun onCompleted() = channel.close()
    }
    api.register(callback)
    /*
     * Suspends until either 'onCompleted'/'onApiError' from the callback is invoked
     * or flow collector is cancelled (e.g. by 'take(1)' or because a collector's coroutine was cancelled).
     * In both cases, callback will be properly unregistered.
     */
    awaitClose { api.unregister(callback) }
}

interface CallbackBasedApi<T> {
    fun register(callback: Callback<T>)
    fun unregister(callback: Callback<T>)
}

class IntApi : CallbackBasedApi<Int> {
    override fun register(callback: Callback<Int>) {
        thread {
            Thread.sleep(1000)
            callback.onNextValue(10)
            callback.onCompleted()
        }
    }

    override fun unregister(callback: Callback<Int>) {
    }

}

fun main():Unit = runBlocking {
    flowFrom(IntApi())
        .map {
            println(Thread.currentThread().name)
        }.collect()

    Thread.sleep(10000)
}


interface Callback<T> {
    fun onNextValue(value: T)
    fun onApiError(cause: Throwable)
    fun onCompleted(): Boolean
}