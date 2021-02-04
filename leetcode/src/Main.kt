import java.util.HashSet

fun main() {
    printDigits(1234567)
}

fun printDigits(number: Int) {
    var remains = number
    while (remains > 0) {
        val mostRightDigit = remains % 10
        remains /= 10
        println("mostRightDigit: $mostRightDigit")
        println("remains: $remains")
    }
}





