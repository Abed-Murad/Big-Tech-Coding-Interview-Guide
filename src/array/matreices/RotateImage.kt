package array.matreices


fun main() {
    // matrix must be N*N
    val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    display(matrix, "init")

    rotate(matrix)
}


fun rotate(matrix: Array<IntArray>) {
    transposeInPlace(matrix)
    display(matrix, "transpose")

    mirrorInPlace(matrix)
    display(matrix, "mirror")

}


// transpose all the rows to columns.
fun transposeInPlace(matrix: Array<IntArray>) {
    val n = matrix.size
    for (i in 0 until n) {
        for (j in i until n) {
            val tmp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = tmp
        }
    }
}

// mirror the rows against the middle using the two pointer technique.
fun mirrorInPlace(matrix: Array<IntArray>) {
    val n = matrix.size
    for (i in 0 until n) {
        for (j in 0 until (n / 2)) {
            val tmp = matrix[i][j]
            matrix[i][j] = matrix[i][(n - 1 - j)]
            matrix[i][(n - 1 - j)] = tmp
        }
    }
}


fun display(matrix: Array<IntArray>, operationName: String) {
    println("The matrix after $operationName : ")
    for (row in matrix) {
        for (column in row) {
            print("$column    ")
        }
        println()
    }
}
