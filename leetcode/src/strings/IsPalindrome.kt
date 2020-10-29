package strings

fun main() {
    println(isPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindrome("race a car"))

}

fun isPalindrome(s: String): Boolean {
    if (s.length < 2) return true
    // I think this is a good solution but regex '*' operation can be memory greedy and
    // Regex in general will slow your execution time!
    val pattern = Regex("[^a-zA-Z0-9]*")
    val cleanText = pattern.replace(s, "").toLowerCase()
    val n = cleanText.length

    for (i in 0 until n / 2) {
        if (cleanText[i] != cleanText[n - 1 - i]) {
            return false
        }
    }
    return true
}