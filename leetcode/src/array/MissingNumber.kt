package array

import java.util.*


fun main() {

}


fun missingNumber(nums: IntArray): Int {
    Arrays.sort(nums)

    // Ensure that n is at the last index
    if (nums[nums.size - 1] != nums.size) {
        return nums.size
    } else if (nums[0] != 0) {
        return 0
    }

    // If we get here, then the missing number is on the range (0, n)
    for (i in 1 until nums.size) {
        val expectedNum = nums[i - 1] + 1
        if (nums[i] != expectedNum) {
            return expectedNum
        }
    }

    // Array was not missing any numbers
    return -1
}