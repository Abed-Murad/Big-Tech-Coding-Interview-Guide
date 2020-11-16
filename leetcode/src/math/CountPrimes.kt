package math

fun main() {
    countPrimes(100)
}


    fun countPrimes(n: Int): Int {
        val isPrime = BooleanArray(n)
        for (i in 2 until n) {
            isPrime[i] = true
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        var i = 2
        while (i * i < n) {
            if (!isPrime[i]) {
                i++
                continue
            }
            var j = i * i
            while (j < n) {
                isPrime[j] = false
                j += i
            }
            i++
        }
        var count = 0
        for (i in 2 until n) {
            if (isPrime[i]) count++
        }
        return count
}