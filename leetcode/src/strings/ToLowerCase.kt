package strings

import java.lang.StringBuilder

fun main() {
toLowerCase("LOVELY")
}

fun toLowerCase(str: String): String {
    var new = StringBuilder()
    for (char in str) {
        if (char.toInt() in 65..90) {
            new.append((char.toInt() + 32).toChar())
        } else {
            new.append(char)
        }
    }
    return new.toString()
}
