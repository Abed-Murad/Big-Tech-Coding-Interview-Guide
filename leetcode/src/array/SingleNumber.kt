package array

fun main() {
    singleNumber(intArrayOf(2, 2, 1))
    singleNumber(intArrayOf(4, 1, 2, 1, 2))
    singleNumber(intArrayOf(1))
}

// Time = O(N), Space = O(N)
// Could be improved to Space = O(1) using Bit manipulation.
fun singleNumber(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    for (num in nums) {
        map[num] = map.getOrDefault(num, 0) + 1
    }

    for (mutableEntry in map) {
        if (mutableEntry.value < 2) return mutableEntry.key
    }

    return 0
}


