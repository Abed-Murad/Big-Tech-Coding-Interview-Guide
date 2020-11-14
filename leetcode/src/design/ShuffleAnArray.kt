package design

import java.util.*


fun main() {
    var x = Solution(intArrayOf(0, 1, 2, 3, 4, 5, 6))
    x.shuffle()
    x.reset()
    x.shuffle()
}

class Solution(private var array: IntArray) {
    private var backup: IntArray = array.clone()
    var rand = Random()

    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray {
        array = backup
        backup = backup.clone()
        return backup
    }

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {
        for (i in array.indices) {
            swapAt(i, randRange(i, array.size))
        }
        return array
    }

    private fun swapAt(i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }

    private fun randRange(min: Int, max: Int): Int {
        val rand = rand.nextInt(max - min)
        val index = rand + min
        return index
    }
}