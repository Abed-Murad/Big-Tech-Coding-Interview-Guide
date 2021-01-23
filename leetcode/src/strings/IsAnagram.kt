package strings

fun main() {
    isAnagram("abed", "deba")
    isAnagram("anagram", "nagaram")
    isAnagram("rat", "car")
}

fun isAnagram(s: String, t: String): Boolean {

    val table = IntArray(26)

    for (c in s) {
        table[c - 'a']++
    }
    for (c in t) {
        table[c - 'a']--
    }

    // Returns `true` if all elements match the given [predicate]<->[ it == 0].
    return table.all {
        it == 0
    }
}

