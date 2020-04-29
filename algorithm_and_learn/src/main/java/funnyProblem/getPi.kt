package funnyProblem

fun main() {
    var times = 100L
    for (i in 1..9) {
        println("loop: $times pi: ${getPi(times)}")
        times *= 10
    }
}

/**
 * 生成 pi
 *
 * @param count 迭代的次数，迭代的次数越多，越接近正确的 pi
 * */
fun getPi(count: Long): Double {
    var c = 0L // 落在圆内的点的计数
    for (i in 0 until count) {
        val x = Math.random()
        val y = Math.random()

        if (x * x + y * y < 1) {
            c++
        }
    }
    return 4.0 * c / count
}