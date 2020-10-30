package integers

fun main() {
    println(addTwoDigits(29))
    println(addTwoDigits(10))

}

fun addTwoDigits(n: Int): Int {
    var sum = 0
    // Parameters in kotlin are final
    var num = n

    while (num != 0) {
        // Add the last digit of 'num'  to 'sum
        sum += (num % 10)
        // Remove the last digit from 'num'
        num /= 10
    }
    return sum
}