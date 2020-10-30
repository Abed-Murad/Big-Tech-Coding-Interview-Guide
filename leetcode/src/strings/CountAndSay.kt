package strings

fun main() {
    println(countAndSay(1))
    println(countAndSay(4))
}


fun countAndSay(n: Int): String? {
    var current = StringBuilder("1")
    var previous: StringBuilder
    var count: Int
    var say: Char
    for (i in 1 until n) {
        previous = current
        current = StringBuilder()
        count = 1
        say = previous[0]
        var j = 1
        val len = previous.length
        while (j < len) {
            if (previous[j] != say) {
                current.append(count).append(say)
                count = 1
                say = previous[j]
            } else count++
            j++
        }
        current.append(count).append(say)
    }
    return current.toString()
}