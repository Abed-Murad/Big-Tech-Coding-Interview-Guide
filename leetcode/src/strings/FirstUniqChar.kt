package strings

fun main() {
    firstUniqChar("leetcode")
    firstUniqChar("abcdefghijklmnopqrstuvwxyziflskecznslkjfabe")
    firstUniqChar("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof")
}

fun firstUniqChar(s: String): Int {
    // Create 'counter array' for all the lowercase letters
    val arr = IntArray(26)
    for (char in s) {
        arr[char - 'a']++  // count++ when you see the letter
    }
    for (i in s.indices) {
        val index = s[i] - 'a' // current letter index in 'counter array'
        if (arr[index] == 1) return i // return the index of the first uniq letter
    }
    return -1
}