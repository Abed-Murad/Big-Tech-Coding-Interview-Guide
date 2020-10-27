package array

fun main() {
    rotate(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3)
    rotate(intArrayOf(1, 2), 3)
}

fun rotate(nums: IntArray, k: Int) {
    var myK = k % nums.size
    reverse(nums, 0, nums.size - 1)
    reverse(nums, 0, myK - 1)
    reverse(nums, myK, nums.size - 1)
}

fun reverse(nums: IntArray, start: Int, end: Int) {
    @Suppress("NAME_SHADOWING")
    var start = start

    @Suppress("NAME_SHADOWING")
    var end = end
    while (start < end) {
        val temp = nums[start]
        nums[start] = nums[end]
        nums[end] = temp
        start++
        end--
    }
}