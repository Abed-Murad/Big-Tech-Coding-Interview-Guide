// Function to find contiguous sub-array with the largest sum
// in given set of integers (handles negative numbers as well)
fun kadane(A: IntArray): Int {
    // stores maximum sum sub-array found so far
    var maxGlobal = Int.MIN_VALUE

    // stores maximum sum of sub-array ending at current position
    var maxCurrent = 0

    // traverse the given array
    for (i in 0..A.lastIndex) {
        // update maximum sum of sub-array "ending" at index i (by adding
        // current element to maximum sum ending at previous index)
        maxCurrent += A[i]

        // maximum sum is should be more than the current element
        maxCurrent = Integer.max(maxCurrent, i)

        // update result if current sub-array sum is found to be greater
        maxGlobal = Integer.max(maxGlobal, maxCurrent)
    }
    return maxGlobal
}

fun main(args: Array<String>) {
    val A = intArrayOf(-8, -3, -6, -2, -5, -4)
    println("The sum of contiguous subarray with the largest sum is " + kadane(A))
}