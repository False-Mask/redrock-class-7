package org.example.callback

/**
 *@author ZhiQiang Tu
 *@time 2022/3/19  13:22
 *@signature 我将追寻并获取我想要的答案
 */
fun main() {
    doTaskA {
        println("taskA总算是执行完了")
        //写入一些逻辑
        doTaskB{
            println("taskB总算是执行完了")
            //写入一些逻辑
            doTaskC{
                println("taskC总算是执行完了")
                //写入一些逻辑
            }
        }
    }
}