package strings

fun main() {
    println(reverseInteger(123))
    println(reverseInteger(-123))

}

/*
    Work with both positive and negative Integers
 */
fun reverseInteger(x: Int): Int {
    if (x == 0) return 0
    var num = x // Can't reassign values to x
    var reversed = 0 // return value
    var digit = 0

    while (num != 0) { // Until no number(pop) remains

        digit = num % 10 // get the last digit

        if (reversed > 2147483647 / 10 || reversed < -2147483648 / 10) {
            return 0 // Big number rule
        }
        reversed = (reversed * 10) + digit // (Create new digit) + add the digit in it place.
        num /= 10 // Move to next digit
    }
    return reversed
}
