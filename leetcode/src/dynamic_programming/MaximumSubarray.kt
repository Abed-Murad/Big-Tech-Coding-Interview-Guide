package dynamic_programming

fun main() {
    maxSubArray(intArrayOf(1, 2, 3, 4, 5))
}

fun maxSubArray(nums: IntArray): Int {
    val n = nums.size
    val memo = IntArray(n)
    memo[0] = nums[0]
    var max = memo[0]
    for (i in 1 until n) {
        memo[i] = nums[i] + if (memo[i - 1] > 0) memo[i - 1] else 0
        max = Math.max(max, memo[i])
    }
    return max
}

