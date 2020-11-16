package bit_manipulation

fun main() {

}

fun hammingWeight(n: Int): Int {
    var n = n
    var sum = 0
    while (n != 0) {
        sum++
        n = n and n - 1
    }
    return sum
}