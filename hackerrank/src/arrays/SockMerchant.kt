package arrays

fun main() {
    sockMerchant(7, arrayOf(1, 2, 1, 2, 1, 3, 2))
}

fun sockMerchant(n: Int, ar: Array<Int>): Int {
    val set = HashSet<Int>()
    var pairsCount = 0
    for (sock in ar) {
        if (!set.contains(sock)) {
            set.add(sock)
        } else {
            pairsCount++
            set.remove(sock)
        }
    }
    return pairsCount
}