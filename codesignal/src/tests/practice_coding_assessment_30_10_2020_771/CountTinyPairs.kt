package tests.practice_coding_assessment_30_10_2020_771

fun main() {

}

// Solve time = 6,  Score = min 300/300
fun countTinyPairs(a: MutableList<Int>, b: MutableList<Int>, k: Int): Int {
    var counter = 0
    for (i in 0 until a.size -1 / 2) {
        var x = a[i]
        var y = b[a.size -1 - i]
        var number = "$x$y".toLong()
        if (number < k) {
            counter++
        }
    }
    return counter
}
