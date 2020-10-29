package strings

// ASCII Codes
// ' ' -> 32
// '+' -> 43
// '-' -> 45
// '0-9' -> 48 - 57

fun main() {
    myAtoi("   -42")
    myAtoi("42")
    myAtoi("4193 with words")
    myAtoi("words and 987")
    myAtoi("-91283472332")
}

fun myAtoi(s: String): Int {
    var i = 0
    var sign = 1
    var result = 0
    if (s.length == 0) return 0

    //Discard whitespaces in the beginning
    while (i < s.length && s[i] == ' ') i++

    // Check if optional sign if it exists
    if (i < s.length && (s[i] == '+' || s[i] == '-')) sign = if (s[i++] == '-') -1 else 1

    // Build the result and check for overflow/underflow condition
    while (i < s.length && s[i] >= '0' && s[i] <= '9') {
        if (result > Int.MAX_VALUE / 10 ||
            result == Int.MAX_VALUE / 10 && s[i] - '0' > Int.MAX_VALUE % 10
        ) {
            return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
        }
        result = result * 10 + (s[i++] - '0')
    }
    return result * sign
}
// atoi stands for (ASCII) to (Integer).
