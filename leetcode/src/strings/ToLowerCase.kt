package strings

import java.lang.StringBuilder

fun main() {
toLowerCase("LOVELY")
}

fun toLowerCase(str: String): String {
    val sb = StringBuilder()
    for (char in str) {
        if (char.toInt() in 65..90) {
            sb.append((char.toInt() + 32).toChar())
        } else {
            sb.append(char)
        }
    }
    return sb.toString()
}
