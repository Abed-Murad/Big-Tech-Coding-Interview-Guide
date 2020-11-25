package search

fun main() {
    val x = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    binarySearch(x, 0, x.lastIndex, 3)
}

// Find out if a key x exists in the sorted array
// A[left..right] or not using binary search algorithm
fun binarySearch(arr: IntArray, start: Int, end: Int, key: Int): Int {
    // Base condition (search space is exhausted)
    if (start > end) {
        return -1
    }

    // we find the mid value in the search space and
    // compares it with key value
    val mid = (start + end) / 2

    // overflow can happen. Use below
    // int mid = left + (right - left) / 2;

    // Base condition (key value is found)
    return if (key == arr[mid]) {
        mid
    } else if (key < arr[mid]) {
        binarySearch(arr, start, mid - 1, key)
    } else {
        binarySearch(arr, mid + 1, end, key)
    }
}