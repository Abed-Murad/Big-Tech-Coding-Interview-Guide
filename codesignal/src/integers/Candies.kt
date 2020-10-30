package integers

fun main() {
    println(candies(3, 10))
}

fun candies(n: Int, m: Int) =   m - m % n

