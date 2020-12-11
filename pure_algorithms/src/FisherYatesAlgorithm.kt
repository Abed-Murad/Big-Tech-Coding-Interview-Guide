import java.util.*
import java.util.Arrays


fun swap(A: Array<Int>, i: Int, j: Int) {
    val tmp = A[i]
    A[i] = A[j]
    A[j] = tmp
}


fun fisherYatesShuffle(A: Array<Int>) {
    val size = A.size
    for (i in 0..size - 2) {
        val j = i + Random().nextInt(size - i) // i <= j < n
        swap(A, i, j)
    }
}

fun main(args: Array<String>) {
    val A = arrayOf(1, 2, 3, 4, 5, 6)
    fisherYatesShuffle(A)

    // print the shuffled array
    println(Arrays.toString(A))
}