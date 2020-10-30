package practice_coding_assessment_30_10_2020_771

import kotlin.collections.HashMap


fun main() {
    hashMap(mutableListOf("insert", "insert", "addToValue", "addToKey", "get") , mutableListOf(mutableListOf(1,2), mutableListOf(2,3), mutableListOf(2), mutableListOf(1), mutableListOf(3)) )

}

// Solve time = 40,  Score = min 73/300
fun hashMap(queryType: MutableList<String>, query: MutableList<MutableList<Int>>): Long {
    val hashMap = HashMap<Int, Int>()
    var sumOfGet: Long = 0
    for (i in queryType.indices) {
        val queryType = queryType[i]
        val parameters: MutableList<Int> = query[i]
        if (queryType == "insert") {
            hashMap[parameters[0]] = parameters[1]
        } else if (queryType == "get") {
            val value = hashMap.getOrDefault(parameters[0], 0)
            sumOfGet += value
        } else if (queryType == "addToKey") {
            increaseAllKeysByOne(hashMap)
        } else if (queryType == "addToValue") {
            for (mutableEntry in hashMap) {
                hashMap[mutableEntry.key] = mutableEntry.value + parameters[0]
            }
        }
    }
    return sumOfGet.toLong()
}


fun increaseAllKeysByOne(map: HashMap<Int, Int>) {
    val newMap = HashMap<Int, Int>()

    for (mutableEntry in map) {
        newMap[mutableEntry.key + 1] = mutableEntry.value
    }
    map.clear()
    map.putAll(newMap)
}