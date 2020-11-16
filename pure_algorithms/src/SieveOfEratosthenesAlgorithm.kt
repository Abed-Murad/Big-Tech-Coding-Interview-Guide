fun main() {
    // Print All Primes less than 100
    sieveOfEratosthenes(100)
}

// Source: https://www.techiedelight.com/sieve-of-eratosthenes/
// The First prime number => 2
// Time complexity =  O(n log (log n))
// Space complexity =  O(n)

// Function to print prime numbers in the range of a given number n
// 1. Take the next available unmarked number in your list (it is prime)
// 2. mark all the multiples of that number (they are not prime)
fun sieveOfEratosthenes(n: Int) {
    val a = IntArray(n + 1)
    for (i in 0..n) { // initialize all numbers as prime
        a[i] = 1
    }
    var i = 2
    while (i  <= Math.sqrt(n.toDouble())) { // uses (i * i) to avoid the heavy call of (Math.sqrt(n.toDouble()))
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
    for (p in 2..n) {
        if (a[p] == 1) {
            print("$i ") // prints primes
        }
    }
}