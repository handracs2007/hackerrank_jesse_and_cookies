import java.util.*

// https://www.hackerrank.com/challenges/jesse-and-cookies/problem

fun cookies(k: Int, A: Array<Int>): Int {
    var steps = 0
    val sweetnessQueue = PriorityQueue<Int>()
    A.forEach { sweetnessQueue.add(it) }

    while (sweetnessQueue.size > 1 && sweetnessQueue.peek() < k) {
        // Get and remove the first sweetness
        val min1 = sweetnessQueue.poll()

        // Get and remove the second sweetness
        val min2 = sweetnessQueue.poll()

        // Calculate new sweetness
        val newSweetness = min1 + 2 * min2

        // Append the new sweetness
        sweetnessQueue.add(newSweetness)

        // Increase the step count
        steps++
    }

    if (sweetnessQueue.peek() < k)
        return -1

    return steps
}

fun main() {
    println(cookies(7, "1 2 3 9 10 12".split(" ").map { it.toInt() }.toTypedArray()))
}