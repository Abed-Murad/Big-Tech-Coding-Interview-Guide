package array

fun main() {
    majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2))
}

// TODO(This is a brute force solution, need improvements!)
fun majorityElement(nums: IntArray): Int {
    val map = HashMap<Int, Int>()
    if (nums.size == 1) return nums[0]
    for (num in nums) {
        if (map.containsKey(num)) {
            var count: Int = map[num]!!
            count++
            if (count > Math.ceil((nums.size / 2).toDouble())) {
                return num
            }
            map[num] = count
        } else {
            map[num] = 1
        }
    }
    return -1
}
