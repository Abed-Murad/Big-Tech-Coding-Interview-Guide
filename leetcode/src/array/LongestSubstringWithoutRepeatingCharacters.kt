package array

// More Optimization are available in leetcode solution tap,
// Ignored for now because it make it more complicated.
// Maybe in the future!
fun lengthOfLongestSubstring(s: String): Int {
    val n = s.length
    val set = HashSet<Char>()
    var ans = 0
    var i = 0
    var j = 0

    while (i < n && j < n) {
        if (!set.contains(s[j])) {
            set.add(s[j++])
            ans = Math.max(ans, j - i)
        } else {
            set.remove(s[i++])
        }
    }
    return ans
}

fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("pwwkew"))
    println(lengthOfLongestSubstring(""))


}