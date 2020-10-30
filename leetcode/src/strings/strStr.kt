package strings

fun main() {
    strStr(haystack = "hello", needle = "ll")
    strStr(haystack = "aaaaa", needle = "bba")
    strStr(haystack = "", needle = "")
}

fun strStr(haystack: String, needle: String): Int {
    // Make sure input is valid
    if (needle.isEmpty()) return 0
    if (haystack.isEmpty()) return -1
    if(needle.length > haystack.length) return -1

    var startIndex = -1

    haystack@ for (i in haystack.indices) {
        val haystackChar = haystack[i]
        val needleChar = needle[0]

        // Compare each letter of the haystack to the first letter of the needle
        if (haystackChar != needleChar) continue
        // Make sure that we still have enough of the haystack
        if(haystack.length - i < needle.length) continue

        // If we reach at this point, we found a potential match.
        startIndex = i
        var needleCounter = 0

        // Loop through all the needle characters and compare with the haystack.
        // Offset the index of the haystack based on the needle index
        while (needleCounter < needle.length - 1) {
            needleCounter++
            val innerHayStackChar = haystack[i + needleCounter]
            val innerNeedleChar = needle[needleCounter]

            if (innerHayStackChar != innerNeedleChar) {
                // Its not completely equal
                // Proceed to the next starting letter of the haystack
                startIndex = -1
                continue@haystack
            }
        }

        // If we reach this point, we found the complete substring
        return startIndex
    }

    return startIndex
}