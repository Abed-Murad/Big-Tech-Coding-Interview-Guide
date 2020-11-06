package arrays

fun main() {
    alternatingSort(mutableListOf<Int>(-52, 2, 31, 56, 47, 29, -35))
}

fun alternatingSort(a: MutableList<Int>): Boolean {
    var n = a.size
    var b = MutableList<Int>(n) { 0 }
    var index = 0
    var start = 0
    var end = a.size - 1
    while (start < end) {
        b[index++] = a[start]
        b[index++] = a[end]
        start++
        end--
    }
    for (i in 0 until b.size - 1) {
        if (b[i] > b[i + 1]) {
            return false
        }
    }
    return true
}
