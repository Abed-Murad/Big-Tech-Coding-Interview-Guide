package array

import kotlin.collections.set


fun main() {
    intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2))
    intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4))

    intersectSorted(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2))
    intersectSorted(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4))
}

// Time O(N+M), Space = O(N) for the HashMap
fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val map = HashMap<Int, Int>()

    for (i in nums1) {
        val freq = map.getOrDefault(i, 0)
        map[i] = freq + 1
    }
    val list = mutableListOf<Int>()
    for (i in nums2) {
        if ((map[i] != null) && (map[i]!! > 0)) {
            list.add(i)
            map[i] = map[i]!! - 1
        }
    }
    return list.toIntArray()
}

// if the arrays were sorted
fun intersectSorted(nums1: IntArray, nums2: IntArray): IntArray {

    nums1.sort()
    nums2.sort()

    val n = nums1.size
    val m = nums2.size
    var i = 0
    var j = 0

    val result = mutableListOf<Int>()

    while (i < n && j < m) {
        val a = nums1[i]
        val b = nums2[j]
        when {
            (a == b) -> {
                result.add(a)
                i++
                j++
            }
            (a < b) -> {
                i++
            }
            else -> {
                j++
            }
        }
    }
    return result.toIntArray()

}
