package strings

fun main() {
    reverseString("123456789".toCharArray())
    reverseStringRecursively("123456789".toCharArray(), 0, "123456789".length - 1)
}

fun reverseString(s: CharArray): Unit {
    var start = 0
    var end = s.size - 1
    while (start < end) {
        val tmp = s[start]
        s[start] = s[end]
        s[end] = tmp
        start++
        end--
    }
}

// This one is not in-place, recursion uses a recursion stack as an auxiliary data structure.
// but it's cool to be able to find the recursion solution at first try.
fun reverseStringRecursively(s: CharArray, start: Int, end: Int) {
    if (start > end) {
        println(s)
        return
    }
    val tmp = s[start]
    s[start] = s[end]
    s[end] = tmp
    reverseStringRecursively(s, start + 1, end - 1)
}
