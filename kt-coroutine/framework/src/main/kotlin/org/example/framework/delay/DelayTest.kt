package org.example.framework.delay

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *@author ZhiQiang Tu
 *@time 2022/3/22  17:19
 *@signature 我将追寻并获取我想要的答案
 */
fun main(){
    GlobalScope.launch {
        while (true){
            delay(1000)
            println("A")
        }
    }
    //delay(1000)
}