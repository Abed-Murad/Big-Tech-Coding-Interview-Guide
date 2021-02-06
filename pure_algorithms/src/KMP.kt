// Function to implement KMP algorithm
fun KMP(X: String?, Y: String?) {
    // Base Case 1: Y is null or empty
    if (Y == null || Y.isEmpty()) {
        println("Pattern occurs with shift 0")
        return
    }

    // Base Case 2: X is null or X's length is less than that of Y's
    if (X == null || Y.length > X.length) {
        println("Pattern not found")
        return
    }
    val chars = Y.toCharArray()

    // next[i] stores the index of next best partial match
    val next = IntArray(Y.length + 1)
    for (i in 1 until Y.length) {
        var j = next[i + 1]
        while (j > 0 && chars[j] != chars[i])
            j = next[j]
        if (j > 0 || chars[j] == chars[i]) next[i + 1] = j + 1
    }
    var i = 0
    var j = 0
    while (i < X.length) {
        if (j < Y.length && X[i] == Y[j]) {
            if (++j == Y.length) {
                println("Pattern occurs with shift " + (i - j + 1))
            }
        } else if (j > 0) {
            j = next[j]
            i-- // since i will be incremented in next iteration
        }
        i++
    }
}

// Program to implement KMP Algorithm in Java
fun main(args: Array<String>) {
    val text = "ABCABAABCABAC"
    val pattern = "CAB"
    KMP(text, pattern)
}
