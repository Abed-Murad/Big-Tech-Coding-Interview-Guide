package array

fun threeSum(sums: IntArray): List<List<Int>> {
    val set = hashSetOf<ArrayList<Int>>()
    for (i in sums.indices) {
        for (j in i..sums.lastIndex) {
            for (k in j..sums.lastIndex) {
                if (i != j && i != k && j != k) {
                    if (sums[i] + sums[j] + sums[k] == 0) {
                        set.add(arrayListOf(sums[i], sums[j], sums[k]))
                    }
                }
            }
        }
    }
//    println(set)
    set.map {
        it.sort()
    }
//    println(set)
    val list = set.toMutableList()

    for (i in list.indices) {
        for (j in i..list.lastIndex) {
            if (list[i].containsAll(list[j]) && list[j].containsAll(list[i]) && list[j].size > 0 && list[i].size > 0 && i != j) {
                list[i].clear()
            }
        }
    }
//    println(list)
    val new = list.filter {
        it.size > 0
    }
    println(new)

    return new

}

fun main() {
    threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
}