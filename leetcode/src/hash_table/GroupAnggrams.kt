package hash_table

import sun.reflect.annotation.AnnotationParser.toArray
import java.util.*
import java.util.ArrayList

import java.util.Arrays
import java.util.HashMap


fun groupAnagrams(strs: Array<String>): List<List<String>> {
    if (strs.isEmpty()) return listOf()
    val ans: MutableMap<String, MutableList<String>> = HashMap()
    for (s in strs) {
        val ca = s.toCharArray()
        Arrays.sort(ca)
        val key = String(ca)
        if (!ans.containsKey(key)) ans[key] = mutableListOf()
        ans[key]!!.add(s)
    }
    return ans.values.toList()
}

fun main() {
    groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
}