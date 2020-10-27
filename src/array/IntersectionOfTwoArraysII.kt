package array

fun main() {
    intersect(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2))
    intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4))
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