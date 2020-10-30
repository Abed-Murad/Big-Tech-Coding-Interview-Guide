package practice_coding_assessment_30_10_2020_771

fun main() {
    meanGroups(
        mutableListOf(
            mutableListOf(3, 3, 4, 2),
            mutableListOf(4, 4),
            mutableListOf(4, 0, 3, 3),
            mutableListOf(2, 3),
            mutableListOf(3, 3, 3)
        )
    )
}

// Solve time = 20,  Score = min 86/300
fun meanGroups(a: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    val hashMap = HashMap<Float, Int>()
    val list = mutableListOf<MutableList<Int>>()

    for (i in a.indices) {
        val mean: Float = (a[i].sum().toFloat() / a[i].size.toFloat())
        if (!hashMap.containsKey(mean)) {
            val subList = mutableListOf<Int>()
            subList.add(i)
            hashMap[mean] = i
            list.add(subList)
        } else {
            val index = hashMap[mean]
            val subList = list[index!!]
            subList.add(i)
            list[index] = subList
        }
    }
    return list
}
