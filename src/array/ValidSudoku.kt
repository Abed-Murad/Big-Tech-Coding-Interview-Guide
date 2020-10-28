package array

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
    val map = HashSet<Char>()
    for (arr in board) {
        for (char in arr) {
            if (char != '.') {
                if (map.contains(char)) {
                    return false
                }
                map.add(char)
            }
        }
        map.clear()
    }

    return true
}