package array.sorting

fun main() {
    sortArray(intArrayOf(1, 4, 6, 2, 7, 8))
}
// This one sucks(Bad leetcode score) cause of line 8
// Replace all the Lists with arrays!
fun sortArray(nums: IntArray): IntArray {
    val result = mergeSort(nums.toMutableList()).toIntArray()
    return result
}

fun mergeSort(list: List<Int>): List<Int> {
    if (list.size < 2) return list

    val middle = list.size / 2
    val left = mergeSort(list.subList(0, middle))
    val right = mergeSort(list.subList(middle, list.size))
    return merge(left, right)
}

fun merge(left: List<Int>, right: List<Int>): List<Int> {
    var indexLeft = 0
    var indexRight = 0
    val list = mutableListOf<Int>()

    while (indexLeft < left.count() && indexRight < right.count()) {
        if (left[indexLeft] <= right[indexRight]) {
            list.add(left[indexLeft])
            indexLeft++
        } else {
            list.add(right[indexRight])
            indexRight++
        }
    }

    while (indexLeft < left.count()) {
        list.add(left[indexLeft])
        indexLeft++
    }
    while (indexRight < right.count()) {
        list.add(right[indexRight])
        indexRight++
    }
    return list
}

