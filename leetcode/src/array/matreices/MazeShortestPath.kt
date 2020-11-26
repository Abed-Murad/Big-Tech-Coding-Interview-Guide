package array.matreices

// M x N matrix
private const val M = 10
private const val N = 10

// Check if it is possible to go to (x, y) from current position. The
// function returns false if the cell has value 0 or already visited
private fun isSafe(mat: Array<IntArray>, visited: Array<IntArray>, x: Int, y: Int): Boolean {
    return !(mat[x][y] == 0 || visited[x][y] != 0)
}

// if not a valid position, return false
private fun isValid(x: Int, y: Int): Boolean {
    return x < M && y < N && x >= 0 && y >= 0
}

// Find Shortest Possible Route in a Matrix mat from source cell (0, 0)
// to destination cell (x, y)
// 'min_dist' stores length of longest path from source to destination
// found so far and 'dist' maintains length of path from source cell to
// the current cell (i, j)
fun findShortestPath(
    mat: Array<IntArray>, visited: Array<IntArray>,
    i: Int, j: Int, x: Int, y: Int, min_dist: Int, dist: Int
): Int {
    // if destination is found, update min_dist
    var min_dist = min_dist
    if (i == x && j == y) {
        return Integer.min(dist, min_dist)
    }

    // set (i, j) cell as visited
    visited[i][j] = 1

    // go to bottom cell
    if (isValid(i + 1, j) && isSafe(mat, visited, i + 1, j)) {
        min_dist = findShortestPath(
            mat, visited, i + 1, j, x, y,
            min_dist, dist + 1
        )
    }

    // go to right cell
    if (isValid(i, j + 1) && isSafe(mat, visited, i, j + 1)) {
        min_dist = findShortestPath(
            mat, visited, i, j + 1, x, y,
            min_dist, dist + 1
        )
    }

    // go to top cell
    if (isValid(i - 1, j) && isSafe(mat, visited, i - 1, j)) {
        min_dist = findShortestPath(
            mat, visited, i - 1, j, x, y,
            min_dist, dist + 1
        )
    }

    // go to left cell
    if (isValid(i, j - 1) && isSafe(mat, visited, i, j - 1)) {
        min_dist = findShortestPath(
            mat, visited, i, j - 1, x, y,
            min_dist, dist + 1
        )
    }

    // Backtrack - Remove (i, j) from visited matrix
    visited[i][j] = 0
    return min_dist
}

fun main(args: Array<String>) {
    val mat = arrayOf(
        intArrayOf(1, 1, 1, 1, 1, 0, 0, 1, 1, 1),
        intArrayOf(0, 1, 1, 1, 1, 1, 0, 1, 0, 1),
        intArrayOf(0, 0, 1, 0, 1, 1, 1, 0, 0, 1),
        intArrayOf(1, 0, 1, 1, 1, 0, 1, 1, 0, 1),
        intArrayOf(0, 0, 0, 1, 0, 0, 0, 1, 0, 1),
        intArrayOf(1, 0, 1, 1, 1, 0, 0, 1, 1, 0),
        intArrayOf(0, 0, 0, 0, 1, 0, 0, 1, 0, 1),
        intArrayOf(0, 1, 1, 1, 1, 1, 1, 1, 0, 0),
        intArrayOf(1, 1, 1, 1, 1, 0, 0, 1, 1, 1),
        intArrayOf(0, 0, 1, 0, 0, 1, 1, 0, 0, 1)
    )

    // construct a matrix to keep track of visited cells
    val visited = Array(M) { IntArray(N) }
    val min_dist = findShortestPath(mat, visited, 0, 0, 7, 5, Int.MAX_VALUE, 0)
    if (min_dist != Int.MAX_VALUE) {
        println(
            "The shortest path from source to destination "
                    + "has length " + min_dist
        )
    } else {
        println("Destination can't be reached from source")
    }
}
