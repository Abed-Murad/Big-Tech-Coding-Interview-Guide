package tests

fun main() {
    smallestPositiveInteger(intArrayOf(1, 2, 4, 50, 5))
}

fun smallestPositiveInteger(A: IntArray): Int {

    var smallestPositiveInteger = 1

    A.sort()

    if (A[A.lastIndex] <= 0) {
        return smallestPositiveInteger
    }

    for (i in A) {
        if (i <= 0) {
            continue
        }
        if (i == smallestPositiveInteger) {
            smallestPositiveInteger++
        } else if (i > smallestPositiveInteger) {
            continue
        }
    }
    return smallestPositiveInteger
}

/**
    Write a function:

    fun solution(A: IntArray): Int

    that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

    Given A = [1, 2, 3], the function should return 4.

    Given A = [−1, −3], the function should return 1.

    Write an efficient algorithm for the following assumptions:

    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [−1,000,000..1,000,000].
 */