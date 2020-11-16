fun main() {
    // Print All Primes less than 100
    sieveOfEratosthenes(100)
}

// Source: https://www.techiedelight.com/sieve-of-eratosthenes/
// The First prime number => 2
// Time complexity =  O(n log (log n))
// Space complexity =  O(n)

// Function to print prime numbers in the range of a given number n
fun sieveOfEratosthenes(n: Int) {
    val a = IntArray(n + 1)
    for (i in 0..n) { // initialize all numbers as prime
        a[i] = 1
    }
    run {
        var i = 2
        while (i <= Math.sqrt(n.toDouble())) {
            if (a[i] == 1) // checks if i is prime
            {
                var j = 2
                while (i * j <= n) {
                    a[i * j] = 0 // multiples of i are not prime
                    j++
                }
            }
            i++
        }
    }
    for (i in 2..n) {
        if (a[i] == 1) {
            print("$i ") // prints primes
        }
    }
}