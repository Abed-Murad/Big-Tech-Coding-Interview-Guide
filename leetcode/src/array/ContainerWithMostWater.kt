package array

import kotlin.math.max
import kotlin.math.min

fun maxArea(height: IntArray): Int {
    var maxArea = -1

    for (i in height.indices) {
        for (j in height.lastIndex downTo 0) {
            val min = Math.min(height[i], height[j])
            val area = min * (j - i)
            if (area > maxArea && j != i) {
                maxArea = area
            }
        }
    }
    return maxArea
}

fun main() {
    println("MaxArea = ${maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))}")
    println("MaxArea = ${maxArea(intArrayOf(4, 3, 2, 1, 4))}")
    println("MaxArea = ${maxArea(intArrayOf(1, 1))}")
    println("MaxArea = ${maxArea(intArrayOf(1, 2, 1))}")
    println("MaxArea = ${maxArea(intArrayOf(0, 0))}")
}

