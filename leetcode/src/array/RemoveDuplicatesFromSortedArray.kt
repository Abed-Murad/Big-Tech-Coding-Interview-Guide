package array

fun removeDuplicates(nums: IntArray): Int {
    var pointer = 0
    for (number in nums) {
        if (pointer == 0 || number > nums[pointer - 1]) {
            nums[pointer++] = number
        }
    }
    return pointer
}

fun main() {
    removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4))
}