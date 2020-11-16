package math

fun main() {
    isPowerOfThree(9)
}

fun isPowerOfThree(n: Int): Boolean {
    if (n < 1) return false

    var value = n
    while (value % 3 == 0) {
        value /= 3
    }
    return value == 1
}