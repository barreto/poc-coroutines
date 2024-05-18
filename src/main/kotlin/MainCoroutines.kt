import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        runBlocking {
            val (res1, res2, res3) = executeCoroutinesInParallel()
            println(res1)
            println(res2)
            println(res3)
        }
    }
    println("\nExecution time: ${executionTime}ms") // Output: near 4000ms
}

suspend fun executeCoroutinesInParallel(): Triple<Response, Response, Response> {
    return coroutineScope {
        val deferred1 = async { fakeRequestSuspend(1000) }
        val deferred2 = async { fakeRequestSuspend(2000) }
        val deferred3 = async { fakeRequestSuspend(4000) }

        Triple(deferred1.await(), deferred2.await(), deferred3.await())
    }
}

suspend fun fakeRequestSuspend(timeToSleepInMs: Long): Response {
    delay(timeToSleepInMs)
    return Response(timeToSleepInMs)
}
