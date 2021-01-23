package hash_table

import java.util.ArrayList

import java.util.HashMap


fun groupAnagrams(strs: Array<String>): List<List<String>> {
    if (strs.isEmpty()) return arrayListOf()
    val map = HashMap<String, ArrayList<String>>()
    for (str in strs) {
        val strArray = str.toCharArray()
        strArray.sort()
        val key = String(strArray)
        if (!map.containsKey(key)) {
            map[key] = arrayListOf()
        }
        map[key]!!.add(str)

    }
    return ArrayList(map.values)
}

fun main() {
    groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
}