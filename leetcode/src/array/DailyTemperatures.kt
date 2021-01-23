package array

import java.util.*

fun dailyTemperatures(T: IntArray): IntArray {
    val stack = Stack<Int>()
    val result = IntArray(T.size)

    for (i in T.indices) {
        while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
            val index = stack.pop()
            result[index] = i - index
        }
        stack.push(i)
    }
    return result
}

fun main() {
    dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73))
}