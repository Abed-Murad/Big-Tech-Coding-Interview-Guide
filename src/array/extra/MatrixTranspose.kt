package array.extra

fun main() {
    val row = 2
    val column = 3
    val matrix = arrayOf(intArrayOf(2, 3, 4), intArrayOf(5, 6, 4))
    display(matrix)

    val transpose = Array(column) { IntArray(row) }

    transposeMatrix(row, column, transpose, matrix)

    display(transpose)
}

private fun transposeMatrix(
    row: Int,
    column: Int,
    transpose: Array<IntArray>,
    matrix: Array<IntArray>
) {
    for (i in 0 until row) {
        for (j in 0 until column) {
            transpose[j][i] = matrix[i][j]
        }
    }
}


fun display(matrix: Array<IntArray>) {
    println("The matrix is: ")
    for (row in matrix) {
        for (column in row) {
            print("$column    ")
        }
        println()
    }
}
