/*
package org.example.framework.flow
import kotlinx.coroutines.flow.*

*/
/**
 *@author ZhiQiang Tu
 *@time 2022/3/23  10:59
 *@signature 我将追寻并获取我想要的答案
 *//*

suspend fun main(){
    flowTransform().map {
        it + 1
    }.collect{
        println(it)
    }

    flowTransform().transform<Int,String> {
        emit(" emit1: $it ")
        emit(" emit2: $it ")
    }
}

fun flowTransform() = flow<Int> {
    repeat(1000){
        emit(it)
    }
}.single()*/
