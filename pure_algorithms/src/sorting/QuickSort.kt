package sorting

import java.util.*


// QuickSort routine
fun quicksort(a: IntArray, start: Int, end: Int) {
    // base condition
    if (start >= end) {
        return
    }

    // rearrange the elements across pivot
    val pivot = partition(a, start, end)

    // recur on sub-array containing elements less than pivot
    quicksort(a, start, pivot - 1)

    // recur on sub-array containing elements more than pivot
    quicksort(a, pivot + 1, end)

}


// Partition using Lomuto partition scheme
fun partition(a: IntArray, start: Int, end: Int): Int {
    // Pick rightmost element as pivot from the array
    val pivot = a[end]

    // elements less than pivot will be pushed to the left of pIndex
    // elements more than pivot will be pushed to the right of pIndex
    // equal elements can go either way
    var pIndex = start

    // each time we finds an element less than or equal to pivot,
    // pIndex is incremented and that element would be placed
    // before the pivot.
    for (i in start until end) {
        if (a[i] <= pivot) {
            swap(a, i, pIndex)
            pIndex++
        }
    }

    // swap pIndex with Pivot
    swap(a, end, pIndex)

    // return pIndex (index of pivot element)
    return pIndex
}


fun main() {
    val a = intArrayOf(9, -3, 5, 2, 6, 8, -6, 1, 3)
    quicksort(a, 0, a.size - 1)

    // print the sorted array
    println(a.contentToString())
}
