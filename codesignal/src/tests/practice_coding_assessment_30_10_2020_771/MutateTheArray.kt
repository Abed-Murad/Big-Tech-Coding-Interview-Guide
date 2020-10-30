package tests.practice_coding_assessment_30_10_2020_771

import java.lang.Exception


fun main() {

}

// Solve time = 6,  Score = min 300/300
fun mutateTheArray(n: Int, a: MutableList<Int>): MutableList<Int> {
    val b = MutableList<Int>(n){0}
    for (i in a.indices) {
        var first = 0
        var second = 0
        var thired = 0

        try {
            first = a[i - 1]
        } catch (e: Exception) {

        }
        try {
            second = a[i]
        } catch (e: Exception) {

        }
        try {
            thired = a[i + 1]
        } catch (e: Exception) {

        }
        b[i] = first + second + thired
    }
    return b
}
