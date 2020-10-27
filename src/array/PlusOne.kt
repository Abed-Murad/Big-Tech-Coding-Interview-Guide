package array

fun main() {
    plusOne(intArrayOf(4, 3, 2, 1))
}


// Loop throw the array
fun plusOne(digits: IntArray): IntArray {

    for (i in digits.lastIndex downTo 0) { // 1,2,3 and others
        if (digits[i] != 9) {
            digits[i]++
            return digits
        } else {
            digits[i] = 0
        }
    }
//  if you reached the end then you need to create new array for the new digit
    val result = IntArray(digits.size + 1) // 9,9,9
    result[0] = 1

    return result
}