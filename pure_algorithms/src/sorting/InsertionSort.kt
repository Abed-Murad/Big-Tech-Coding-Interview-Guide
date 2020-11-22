package sorting

fun main() {
    println(insertionSort(intArrayOf(3, 8, 5, 4, 1, 9, -2)).toList())
}

// Time complexity =  O(n2)
// Space complexity =  O(1)
// Notes: The main trick is understanding the life-cycle of 'holePosition' !
fun insertionSort(arr: IntArray): IntArray {
    val lastIndex = arr.size - 1

    // Un-sorted array from position 1 to size -1
    for (i in 1..lastIndex) {
        // Take the left most item in an un-sorted array to tmp variable.
        val tmp = arr[i]
        // Mark the left-most position of the un-sorted array as an empty or a hole
        var holePosition = i
        // Traverse the sorted array from right to left direction
        // Move the item from the sorted array to the emptyPosition, only if the temp variable is less than
        // Mark the current item's position as empty by decrementing the value by one
        while (holePosition > 0 && arr[holePosition - 1] > tmp) {
            arr[holePosition] = arr[holePosition - 1]
            holePosition -= 1
        }
        // Once the comparison is done, move the value in tmp variable to the lastly marked empty position.
        arr[holePosition] = tmp
    }
    return arr
}
