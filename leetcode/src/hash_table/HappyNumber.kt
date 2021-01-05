package hash_table

import java.util.HashSet


fun isHappy(n: Int): Boolean {
    var n = n
    val set = HashSet<Int>()
    var sum: Int
    var remain: Int
    while (set.add(n)) {
        sum = 0
        while (n > 0) {
            remain = n % 10
            sum += remain * remain
            n /= 10
        }
        n = if (sum == 1) return true else sum
    }
    return false
}

fun main() {
    isHappy(19)
    isHappy(2)
}