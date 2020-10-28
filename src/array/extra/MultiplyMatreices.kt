package array.extra

fun main() {

    val r1 = 2
    val c1 = 3
    val r2 = 3
    val c2 = 2

    val firstMatrix = arrayOf(intArrayOf(3, -2, 5), intArrayOf(3, 0, 4))
    val secondMatrix = arrayOf(intArrayOf(2, 3), intArrayOf(-9, 0), intArrayOf(0, 4))

    val product = multiplyMatrices(firstMatrix, secondMatrix, r1, c1, c2)

    displayProduct(product)
}

fun multiplyMatrices(
    firstMatrix: Array<IntArray>,
    secondMatrix: Array<IntArray>,
    r1: Int,
    c1: Int,
    c2: Int
): Array<IntArray> {
    val product = Array(r1) { IntArray(c2) }
    for (i in 0 until r1) {
        for (j in 0 until c2) {
            for (k in 0 until c1) {
                product[i][j] += firstMatrix[i][k] * secondMatrix[k][j]
            }
        }
    }
    return product
}

fun displayProduct(product: Array<IntArray>) {
    println("Product of two matrices is: ")
    for (row in product) {
        for (column in row) {
            print("$column    ")
        }
        println()
    }
}
