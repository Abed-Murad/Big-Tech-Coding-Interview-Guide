package sorting

fun main() {
    selectionSort(intArrayOf(3, 5, 8, 4, 1, 9, -2))
}

// Time complexity =  O(n^2)
// Space complexity =  O(1)
// Notes:
fun selectionSort(arr: IntArray): IntArray {
    var lastIndex = arr.size - 1

    // find the minimum element in the unsorted sub-array[i..n-1]
    // and swap it with arr[i]
    for (i in 0..lastIndex) {
        var min = i
        for (j in i + 1..lastIndex) {
            // if arr[j] element is less, then it is the new minimum
            if (arr[j] < arr[min]) {
                min = j // update index of min element
            }
        }
        // swap the minimum element in sub-array[i..n-1] with arr[i]
        swap(arr, min, i)
    }
    return arr
}


fun swap(arr: IntArray, i: Int, j: Int) {
    val tmp = arr[i]
    arr[i] = arr[j]
    arr[j] = tmp
}