package arrays

import java.lang.StringBuilder

fun main() {
    isCryptSolution(
        mutableListOf("TEN", "TWO", "ONE"),
        mutableListOf(
            mutableListOf('O', '1'),
            mutableListOf('T', '0'),
            mutableListOf('W', '9'),
            mutableListOf('E', '5'),
            mutableListOf('N', '4')
        )
    )
}

fun isCryptSolution(crypt: MutableList<String>, solution: MutableList<MutableList<Char>>): Boolean {
    val map = HashMap<Char, Int>()

    for (list in solution) {
        map[list[0]] = Character.getNumericValue(list[1])
    }

    var first = StringBuilder()
    var second = StringBuilder()
    var third = StringBuilder()

    for (char in crypt[0]) {
        first.append(map[char])
    }
    for (char in crypt[1]) {
        second.append(map[char])
    }
    for (char in crypt[2]) {
        third.append(map[char])
    }

    if (first.startsWith('0') && first.length > 1) return false
    if (second.startsWith('0') && second.length > 1) return false
    if (third.startsWith('0') && third.length > 1) return false

    if (first.toString().toLong() + second.toString().toLong() != third.toString().toLong()) return false

    return true
}
