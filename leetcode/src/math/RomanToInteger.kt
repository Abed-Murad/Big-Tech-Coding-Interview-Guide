package math


fun main() {

}

enum class Roman(val value: Int) {
    I(1), V(5), X(10), L(50), C(100), D(500), M(1000)
}

fun romanToInt(s: String): Int {
    var result = 0
    var index = -1
    while (++index < s.length) {
        val currentVal: Int = Roman.valueOf(s[index].toString()).value
        if (index + 1 < s.length) {
            val nextVal: Int = Roman.valueOf(s[index + 1].toString()).value
            if (nextVal > currentVal) {
                result += (nextVal - currentVal)
                index++
                continue
            }
        }
        result += currentVal
    }
    return result
}