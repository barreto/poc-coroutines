import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val (res1, res2, res3) = executeThreadsInParallel()
        println(res1)
        println(res2)
        println(res3)
    }
    println("\nExecution time: ${executionTime}ms") // Output: also near 4000ms (but too verbose)
}

fun executeThreadsInParallel(): Triple<Response, Response, Response> {
    var result1 = Response(-1)
    var result2 = Response(-1)
    var result3 = Response(-1)

    val thread1 = thread { result1 = fakeRequest(1000) }
    val thread2 = thread { result2 = fakeRequest(2000) }
    val thread3 = thread { result3 = fakeRequest(4000) }

    thread1.join()
    thread2.join()
    thread3.join()

    return Triple(result1, result2, result3)
}
