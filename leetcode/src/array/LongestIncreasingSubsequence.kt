package array


fun lengthOfLIS(nums: IntArray): Int {
    return LIS(nums, 0, nums.size, Int.MIN_VALUE)
}

// Function to find length of longest increasing subsequence
fun LIS(A: IntArray, i: Int, n: Int, prev: Int): Int {
    // Base case: nothing is remaining
    if (i == n)  return 0

    // case 1: exclude the current element and process the
    // remaining elements
    val exclude: Int = LIS(A, i + 1, n, prev)

    // case 2: include the current element if it is greater
    // than previous element in LIS
    var include = 0
    if (A[i] > prev) {
        include = 1 + LIS(A, i + 1, n, A[i])
    }

    // return maximum of above two choices
    return Integer.max(include, exclude)
}

fun main() {
    val array = intArrayOf(0, 8, 4, 12)
    println("Length of LIS is ${lengthOfLIS(array)}")
}