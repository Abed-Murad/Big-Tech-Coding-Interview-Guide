package heap

import kotlin.collections.HashMap
import java.util.PriorityQueue

import java.util.Queue

// Check this out -> https://leetcode.com/problems/top-k-frequent-elements/Figures/347_rewrite/summary.png

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    // O(1) time
    if (k == nums.size) {
        return nums
    }

    // 1. build hash map : character and how often it appears
    // O(N) time
    val map: MutableMap<Int?, Int?> = HashMap()
    for (n in nums) {
        map[n] = map.getOrDefault(n, 0)!! + 1
    }

    // init heap 'the less frequent element first'
    val heap: Queue<Int> = PriorityQueue { n1: Int?, n2: Int? -> map[n1]!! - map[n2]!! }

    // 2. keep k top frequent elements in the heap
    // O(N log k) < O(N log N) time
    for (n in map.keys) {
        heap.add(n)
        if (heap.size > k) heap.poll()
    }

    // 3. build an output array
    // O(k log k) time
    val top = IntArray(k)
    for (i in k - 1 downTo 0) {
        top[i] = heap.poll()
    }
    return top
}

fun main() {
    topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2)
}