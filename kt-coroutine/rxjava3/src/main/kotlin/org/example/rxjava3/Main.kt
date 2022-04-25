package org.example.rxjava3

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 *@author ZhiQiang Tu
 *@time 2022/3/19  13:52
 *@signature 我将追寻并获取我想要的答案
 */
fun main() {
    taskA()
        .flatMap {
            println("taskA完成")
            taskB()
        }
        .flatMap {
            println("taskB完成")
            taskC()
        }
        .subscribeOn(Schedulers.io())
        .subscribe()


    Thread.sleep(10000)
}