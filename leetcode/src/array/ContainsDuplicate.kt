package array

fun main() {
    containsDuplicate(intArrayOf(1, 2, 3, 1))
}


// Time = O(N), Space = O(N).
fun containsDuplicate(nums: IntArray): Boolean {
    val hashSet = HashSet<Int>()
    for (num in nums) {
        if (hashSet.contains(num)) {
            return true
        } else {
            hashSet.add(num)
        }
    }
    return false
}
/* Extra Notes */
// Sorting an array cost O(log n)