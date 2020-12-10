import java.util.Arrays


// Below arrays details all 8 possible movements
private val row = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
private val col = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

fun isSave(M: Array<CharArray>, x: Int, y: Int, target: Char): Boolean {
    return x >= 0 && x < M.size && y >= 0 && y < M[0].size && M[x][y] == target
}

// This is a DFS, while there is a BFS, this one is better because it does not need an auxiliary array for visited nodes
fun floodfill(M: Array<CharArray>, x: Int, y: Int, replacement: Char) {
    val target = M[x][y]
    M[x][y] = replacement

    for (k in 0 until 8) {
        if (isSave(M, x + row[k], y + col[k], target)) {
            floodfill(M, x + row[k], y + col[k], replacement)
        }
    }
}

fun main(args: Array<String>) {
    // matrix showing portion of the screen having different colors
    val M = arrayOf(
        "YYYGGGGGGG".toCharArray(),
        "YYYYYYGXXX".toCharArray(),
        "GGGGGGGXXX".toCharArray(),
        "WWWWWGGGGX".toCharArray(),
        "WRRRRRGXXX".toCharArray(),
        "WWWRRGGXXX".toCharArray(),
        "WBWRRRRRRX".toCharArray(),
        "WBBBBRRXXX".toCharArray(),
        "WBBXBBBBXX".toCharArray(),
        "WBBXXXXXXX".toCharArray()
    )

    // start node
    val x = 3
    val y = 9 // having target color = "X"

    // replacement color
    val replacement = 'C'

    // print the colors before replacement
    for (row in M) {
        println(Arrays.toString(row))
    }


    // replace target color with replacement color using DFS
    floodfill(M, x, y, replacement)

    // print the colors after replacement
    for (row in M) {
        println(Arrays.toString(row))
    }
}