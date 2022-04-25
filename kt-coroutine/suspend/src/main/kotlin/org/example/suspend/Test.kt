package org.example.suspend

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

val l = listOf(1,2)


suspend fun main() {
    println(l)
}


