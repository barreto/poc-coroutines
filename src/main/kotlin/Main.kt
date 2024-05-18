import kotlin.system.measureTimeMillis

fun main() {
    val executionTime = measureTimeMillis {
        val res1 = fakeRequest(1000)
        println(res1)

        val res2 = fakeRequest(2000)
        println(res2)

        val res3 = fakeRequest(4000)
        println(res3)
    }
    println("\nExecution time: ${executionTime}ms") // Output: near 7000ms
}

fun fakeRequest(timeToSleepInMs: Long): Response {
    Thread.sleep(timeToSleepInMs)
    return Response(timeToSleepInMs);
}
