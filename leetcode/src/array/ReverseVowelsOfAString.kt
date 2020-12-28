package array


// English vowels: A, E, I, O, U
// English consonants: B, C, D, F, G, H, J, K, L, M, N, P, Q, R, S, T, V, W, X, Y, Z
fun reverseVowels(s: String): String {
    val s = s.toCharArray()
    var start = 0
    var end = s.size - 1
    while (start < end) {
        if (s[start].isVowel() && s[end].isVowel()) {
            s.swap(start++, end--)
        }
        if (!s[start].isVowel()) {
            start++
        }
        if (!s[end].isVowel()) {
            end--
        }
    }
    return String(s)
}

private fun Char.isVowel(): Boolean {
    val c = this.toLowerCase()
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
}

private fun CharArray.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}


fun main() {
    println(reverseVowels("Euston saw I was not Sue."))
}