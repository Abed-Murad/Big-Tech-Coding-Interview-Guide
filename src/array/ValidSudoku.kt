package array

import java.util.*
import kotlin.collections.HashMap


fun main() {
    isValidSudoku(
        arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
    )
}


fun isValidSudoku(board: Array<CharArray>): Boolean {
    // init data
    val rows = HashMap<Int, HashMap<Int, Int>>(9)
    val columns = HashMap<Int, HashMap<Int, Int>>(9)
    val boxes = HashMap<Int, HashMap<Int, Int>>(9)
    for (i in 0..8) {
        rows[i] = HashMap()
        columns[i] = HashMap()
        boxes[i] = HashMap()
    }

    // validate a board
    for (i in 0..8) {
        for (j in 0..8) {
            val num = board[i][j]
            if (num != '.') {
                val number = num.toInt()
                val boxIndex = i / 3 * 3 + j / 3

                // keep the current cell value
                rows[i]!![number] = rows[i]!!.getOrDefault(number, 0) + 1
                columns[i]!![number] = columns[i]!!.getOrDefault(number, 0) + 1
                boxes[boxIndex]!![number] = boxes[boxIndex]!!.getOrDefault(number, 0) + 1

                // check if this value has been already seen before
                if (rows[i]!![number]!! > 1 || columns[i]!![number]!! > 1 || boxes[boxIndex]!![number]!! > 1) {
                    return false
                }
            }
        }
    }
    return true
}


// Priority: P0