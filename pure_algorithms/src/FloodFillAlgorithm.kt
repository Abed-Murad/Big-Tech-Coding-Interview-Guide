import java.util.Arrays

// Below arrays details all 8 possible movements
private val row = intArrayOf(-1, -1, -1, 0, 0, 1, 1, 1)
private val col = intArrayOf(-1, 0, 1, -1, 1, -1, 0, 1)

// check if it is possible to go to pixel (x, y) from
// current pixel. The function returns false if the pixel
// has different color or it is not a valid pixel
fun isSafe(M: Array<CharArray>, x: Int, y: Int, target: Char): Boolean {
    return x >= 0 && x < M.size && y >= 0 && y < M[0].size && M[x][y] == target
}

// Flood fill using DFS
fun floodfill(M: Array<CharArray>, x: Int, y: Int, replacement: Char) {
    // get target color
    val target = M[x][y]

    // replace current pixel color with that of replacement
    M[x][y] = replacement

    // process all 8 adjacent pixels of current pixel and
    // recur for each valid pixel
    for (k in row.indices) {
        // if the adjacent pixel at position (x + row[k], y + col[k]) is
        // a valid pixel and have same color as that of the current pixel
        if (isSafe(M, x + row[k], y + col[k], target))
            floodfill(M, x + row[k], y + col[k], replacement)
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

    // replace target color with replacement color using DFS
    floodfill(M, x, y, replacement)

    // print the colors after replacement
    for (row in M) {
        println(Arrays.toString(row))
    }
}
