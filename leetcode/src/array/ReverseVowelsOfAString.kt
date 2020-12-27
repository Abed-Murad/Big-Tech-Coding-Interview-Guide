package array

import java.lang.StringBuilder

// English vowels: A, E, I, O, U
// English consonants: B, C, D, F, G, H, J, K, L, M, N, P, Q, R, S, T, V, W, X, Y, Z
fun reverseVowels(s: String): String {
    var s = s.toCharArray()
    var start = 0
    var end = s.lastIndex

    var endVowel = -1
    var startVowel = -1
    while (start < end) {
        if (startVowel > 0 && endVowel > 0) {
            val tmp = s[startVowel]
            s[startVowel] = s[endVowel]
            s[endVowel] = tmp
            startVowel = -1
            endVowel = -1
        }
        if (s[start].toLowerCase() in arrayListOf('a', 'e', 'i', 'o', 'u')) {
            startVowel = start
        }
        if (s[end].toLowerCase() in arrayListOf('a', 'e', 'i', 'o', 'u')) {
            endVowel = end
        }

        if (startVowel != -1 && endVowel != 0) {
            val tmp = s[startVowel]
            s[startVowel] = s[endVowel]
            s[endVowel] = tmp
            startVowel = -1
            endVowel = -1
        }

        start++
        end--
    }
    return String(s)

}

fun main() {
    println(reverseVowels("ai"))
}