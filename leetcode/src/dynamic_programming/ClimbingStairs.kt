package dynamic_programming

fun main() {
    println(climbStairs(5))
}

fun climbStairs(n: Int): Int {
    if (n <= 0) return 0
    if (n == 1) return 1
    if (n == 2) return 2

    var oneStepBefore = 2
    var twoStepBefore = 1
    var allWays = 0

    for (i in 2 until n) {
        allWays = oneStepBefore + twoStepBefore
        twoStepBefore = oneStepBefore
        oneStepBefore = allWays
    }
    return allWays
}