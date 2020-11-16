package bit_manipulation

fun main() {

}

fun hammingDistance(x: Int, y: Int): Int {
    val `val` = x xor y
    var count = 0
    var k = 32
    var s = 1

    while (k >= 0) {
        if (`val` and s != 0) count++
        s = s shl 1
        k--
    }
    return count
}