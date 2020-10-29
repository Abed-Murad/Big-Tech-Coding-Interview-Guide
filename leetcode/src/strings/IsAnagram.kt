package strings

fun main() {
    isAnagram("abed", "deba")
    isAnagram("anagram", "nagaram")
    isAnagram("rat", "car")
}

// Better space complexity
fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val table = IntArray(26)

    for (char in s) {
        table[char - 'a']++
    }

    for (char in t) {
        table[char - 'a']--
    }

    return table.all { it == 0 }
}

// My original solution
fun isAnagramWithHashMap(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val firstMap = HashMap<Char, Int>()
    val secondMap = HashMap<Char, Int>()

    for (char in s) {
        val count = firstMap.getOrDefault(char, 0)
        firstMap[char] = count + 1
    }

    for (char in t) {
        val count = secondMap.getOrDefault(char, 0)
        secondMap[char] = count + 1
    }
    if (firstMap.size != secondMap.size) return false
    for (char in t) {
        if (secondMap[char] != firstMap[char]) {
            return false
        }
    }
    return true

}