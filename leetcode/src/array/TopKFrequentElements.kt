package array

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val map = HashMap<Int, Int>()

    for (n in nums) {
        val value = map.getOrDefault(n, 0)
        map[n] = value + 1

    }
    map.toSortedMap()
    return intArrayOf(1)
}

fun main() {
    topKFrequent(intArrayOf(2, 1, 1, 2, 2, 3), 2)
}