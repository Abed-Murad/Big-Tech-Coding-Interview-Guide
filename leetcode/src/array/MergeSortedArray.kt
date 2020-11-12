package array

fun main() {
    merge(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 5, 6), 3)
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var i = m - 1;
    var j = n - 1;
    var currIndex = nums1.size - 1
    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[currIndex--] = nums1[i--]
        } else {
            nums1[currIndex--] = nums1[j--]
        }
    }
    while (j >= 0) { // to fill the remaining nums2
        nums1[currIndex--] = nums2[j--];
    }
}