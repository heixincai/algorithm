package test

import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.reflect.typeOf



class MyClass: CoroutineScope by CoroutineScope(Dispatchers.Default) {

    // 启动协程去做一些事情
    fun doWork() = launch {
        // do things
    }

    // 做一件耗时1000毫秒的事情，并返回一个结果
    fun doWorkAsync() = async {
        delay(1000)
        100
    }

    // 同时做两件耗时的事情，并将它们的结果加在一起
    suspend fun doTwoThing(): Int = coroutineScope {

        coroutineScope {
            val a = async {
                delay(1000)
                100
            }

            val b = async {
                delay(1000)
                200
            }

            a.await() + b.await()
        }
    }

    fun destroy() {
        (this as CoroutineScope).cancel()
    }
}

fun doThings() = GlobalScope.launch {

}

fun main() = runBlocking {

    val myClass = MyClass()

    myClass.doWork()

    val ret1 = myClass.doWorkAsync().await()
    println(ret1)

    val ret2 = myClass.doTwoThing()
    println(ret2)


    Thread.sleep(500) // 让协程工作一会

    Thread.sleep(500) // 等一会方便观察输出
}