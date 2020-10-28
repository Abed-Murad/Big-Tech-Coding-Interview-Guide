package array

import java.util.*


fun main() {
    twoSum(intArrayOf(3, 3), 6)
}

fun twoSum(numbers: IntArray, target: Int): IntArray? {
    val result = IntArray(2)
    val map: MutableMap<Int, Int> = HashMap()
    for (i in numbers.indices) {
        if (map.containsKey(target - numbers[i])) {
            result[1] = i
            result[0] = map[target - numbers[i]]!!
            return result
        }
        map[numbers[i]] = i
    }
    return result
}