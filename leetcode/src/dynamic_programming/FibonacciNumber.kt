package dynamic_programming


fun main() {
    println(RecursiveFib.fib(5))
    println(fibBottomUP(5))
    println(IterativeFib.fib(5))
}

object RecursiveFib {

// Time complexity =  O(2^n)
// Space complexity =  O(n)
// Notes: Approach 1: Recursion
    fun fib(n: Int): Int {
        return if (n <= 1) {
            n
        } else fib(n - 1) + fib(n - 2)
    }
}


// Time complexity =  O(n)
// Space complexity =  O(n)
// Notes: Approach 2: Bottom-Up Approach using Memoization
fun fibBottomUP(n: Int): Int {
    if (n <= 1) {
        return n
    }
    return memoize(n)
}

fun memoize(n: Int): Int {
    val memo = IntArray(n + 1)
    memo[1] = 1
    for (i in 2..n) {
        memo[i] = memo[i - 1] + memo[i - 2]
    }
    println(memo.toList())
    return memo[n]
}


// Time complexity =  O(n)
// Space complexity =  O(n)
// Notes: Approach 3: Top-Down Approach using Memoization
val memo = IntArray(31) { Int.MIN_VALUE }
fun fibTopDown(n: Int): Int {
    if (n <= 1) {
        return n
    }
    memo[0] = 1
    memo[1] = 1
    return memoizeTopDown(n)
}

fun memoizeTopDown(n: Int): Int {
    if (memo[n] != Int.MIN_VALUE) {
        return memo[n]
    }
    memo[n] = memoizeTopDown(n - 1) + memoizeTopDown(n - 2)
    return memo[n]
}


object IterativeFib {
    // Time complexity =  O(n)
    // Space complexity =  O(1)
    // Notes: Cool cool cool
    fun fib(n: Int): Int {
        if (n <= 1) return n
        if (n == 2) return 1
        var prev1 = 1
        var prev2 = 1
        var current = 0
        for (i in 3..n) {
            current = prev1 + prev2
            prev2 = prev1
            prev1 = current
        }
        return current
    }
}

