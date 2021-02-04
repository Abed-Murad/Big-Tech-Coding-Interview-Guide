import kotlin.math.sqrt

fun mySqrt(x: Int): Int {
    if (x == 0) {
        return 0
    }
    var left = 1
    var right = Int.MAX_VALUE
    while (true) {
        val mid = left + (right - left) / 2
        if (mid > x / mid) {
            right = mid - 1
        } else {
            if (mid + 1 > x / (mid + 1)) {
                return  mid
            }
            left = mid + 1
        }
    }
}


