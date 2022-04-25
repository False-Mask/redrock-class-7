package org.example.callback

import kotlin.concurrent.thread

/**
 *@author ZhiQiang Tu
 *@time 2022/3/19  13:19
 *@signature 我将追寻并获取我想要的答案
 */

fun doTaskA(taskA: TaskACallback) {
    thread {
        println("taskA:假装我在做耗时任务")
        Thread.sleep(1000)
        taskA.executeA()
    }
}

fun doTaskB(taskB: TaskBCallback) {
    thread {
        println("taskB:假装我在做耗时任务")
        Thread.sleep(1000)
        taskB.executeB()
    }
}

fun doTaskC(taskC: TaskCCallback) {
    thread {
        println("taskC:假装我在做耗时任务")
        Thread.sleep(1000)
        taskC.executeC()
    }
}






