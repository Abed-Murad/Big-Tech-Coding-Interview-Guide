package array

fun main() {
    moveZeroes(intArrayOf(0, 1, 0, 3, 12))
}

// Time = O(N), Space O(1).
fun moveZeroes(nums: IntArray): IntArray {
    var index = 0
    for (i in nums.indices) {
        if (nums[i] != 0) {
            nums[index++] = nums[i]
        }
    }
    for (i in index..nums.lastIndex) {
        nums[i] = 0
    }
    return nums
}