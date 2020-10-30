package strings

fun main() {
    longestCommonPrefix(arrayOf("flower", "flow", "flight"))
    longestCommonPrefix(arrayOf("dog", "racecar", "car"))
}


fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    // Set the prefix as the first element of the array.
    var prefeix = strs[0] // worst case the hole first would is included in all the strings

    for (i in strs.indices) {
        // while we can't find that prefix at the beginning of this string
        // indexOf() Returns the index of the first occurrence of the specified [string],
        while (strs[i].indexOf(prefeix) != 0) {
            // remove a letter form the end of the prefix
            prefeix = prefeix.substring(0, prefeix.length - 1)
        }
    }
    // after looping throw all the strings, the longest common prefix will remain
    return prefeix
}