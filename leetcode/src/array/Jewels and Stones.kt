package array

fun numJewelsInStones(jewels: String, stones: String): Int {
    val map = HashMap<Char, Int>()
    var total = 0
    for (n in jewels) {
        map[n] = map.getOrDefault(n, 0)
    }
    for (stone in stones) {
        if (map.containsKey(stone)) {
            total++
        }
    }
    return total
}

fun main() {
    numJewelsInStones("" , "")
}