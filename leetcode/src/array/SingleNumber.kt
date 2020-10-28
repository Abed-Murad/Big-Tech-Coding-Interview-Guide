package array

fun main() {
    singleNumber(intArrayOf(2, 2, 1))
    singleNumber(intArrayOf(4, 1, 2, 1, 2))
    singleNumber(intArrayOf(1))
}

// Time = O(N), Space = O(N)
fun singleNumber(nums: IntArray): Int {
    val hashMap = HashMap<Int, Int>()
    for (num in nums) {
        if (hashMap.containsKey(num)) {
            val value = hashMap[num]!!
            hashMap[num] = value + 1
        } else {
            hashMap[num] = 1
        }
    }
    for (mutableEntry in hashMap) {
        if (mutableEntry.value < 2) return mutableEntry.key
    }
    return -1
}


//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.