package integers

import kotlin.math.pow

fun main() {
    println(largestNumber(1))
    println(largestNumber(5))

}


fun largestNumber(n: Int) = Math.pow(10.toDouble() , n.toDouble()) -1
