package array

fun lengthOfLongestSubstring(s: String): Int {
    val n = s.length
    var ans = 0
    for (i in 0 until n) {
        for (j in i + 1..n) {
            if (allUnique(s, i, j)) ans = Math.max(ans, j - i)
        }
    }
    return ans
}

fun allUnique(s: String, start: Int, end: Int): Boolean {
    val set = HashSet<Char>()
    for (i in start until end) {
        var ch = s[i]
        if (set.contains(ch)) return false
        set.add(ch)
    }
    return true
}

fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("pwwkew"))
    println(lengthOfLongestSubstring(""))
}