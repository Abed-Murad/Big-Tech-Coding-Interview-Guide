package dynamic_programming

fun main() {

}

fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var prev1 = 0
    var prev2 = 0
    for (num in nums) {
        val tmp = prev1
        prev1 = Math.max(prev2 + num, prev1)
        prev2 = tmp
    }
    return prev1
}