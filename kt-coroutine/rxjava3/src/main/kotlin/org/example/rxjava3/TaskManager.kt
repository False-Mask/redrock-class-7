package org.example.rxjava3

import io.reactivex.rxjava3.core.Observable

/**
 *@author ZhiQiang Tu
 *@time 2022/3/19  13:55
 *@signature 我将追寻并获取我想要的答案
 */

fun taskA() = Observable.create<Unit> { it.onNext(Unit) }
    .map {
        println("taskA:假装我在做耗时任务")
        Thread.sleep(1000)
    }

fun taskB() = Observable.create<Unit> { it.onNext(Unit) }
    .map {
        println("taskB:假装我在做耗时任务")
        Thread.sleep(1000)
    }

fun taskC() = Observable.create<Unit> { it.onNext(Unit) }
    .map {
        println("taskC:假装我在做耗时任务")
        Thread.sleep(1000)
    }