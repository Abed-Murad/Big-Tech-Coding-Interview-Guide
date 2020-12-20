package array

import java.util.Arrays

import java.util.LinkedList


fun threeSum(num: IntArray): List<List<Int>> {
    Arrays.sort(num)
    val res: MutableList<List<Int>> = LinkedList()
    for (i in 0 until num.size - 2) {
        if (i == 0 || i > 0 && num[i] != num[i - 1]) {
            var low = i + 1
            var high = num.size - 1
            val sum = 0 - num[i]
            while (low < high) {
                if (num[low] + num[high] == sum) {
                    res.add(listOf(num[i], num[low], num[high]))
                    while (low < high && num[low] == num[low + 1]) low++
                    while (low < high && num[high] == num[high - 1]) high--
                    low++
                    high--
                } else if (num[low] + num[high] < sum) low++ else high--
            }
        }
    }
    return res
}

fun main() {
    threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
}