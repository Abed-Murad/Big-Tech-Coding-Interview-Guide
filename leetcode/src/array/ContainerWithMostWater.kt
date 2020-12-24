package array


// Updated solution based on the work of our lord and savior @stefanPochmann from leetcode.
fun maxArea(height: IntArray): Int {
    var maxArea = 0
    var i = 0
    var j = height.size - 1

    while (i < j) {
        val width = j - i
        val minLength = Math.min(height[i], height[j])
        maxArea = Math.max(maxArea, width * minLength)

        if (height[i] > height[j]) {
            j--
        } else {
            i++
        }
    }
    return maxArea
}

fun main() {
    println("MaxArea = ${maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))}")
    println("MaxArea = ${maxArea(intArrayOf(4, 3, 2, 1, 4))}")
    println("MaxArea = ${maxArea(intArrayOf(1, 1))}")
    println("MaxArea = ${maxArea(intArrayOf(1, 2, 1))}")
    println("MaxArea = ${maxArea(intArrayOf(0, 0))}")
}

