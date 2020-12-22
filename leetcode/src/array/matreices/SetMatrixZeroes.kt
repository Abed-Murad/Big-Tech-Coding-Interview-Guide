package array.matreices

fun setAZeroes(matrix: Array<IntArray>): Unit {
    for (i in matrix.indices) {
        for (j in 0..matrix[i].lastIndex) {
            if (matrix[i][j] == 0) {
                matrix[i] = intArrayOf()
                for (column in matrix.indices) {

                }
            }
        }
        println()
    }
}

fun main() {
    setAZeroes(arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 1)))
}