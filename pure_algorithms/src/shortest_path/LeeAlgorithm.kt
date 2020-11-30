package shortest_path

import java.util.*


// queue node used in BFS
internal class Node(// (x, y) represents matrix cell coordinates
    // dist represent its minimum distance from the source
    var x: Int, var y: Int, var dist: Int
)

internal object Main {
    // M x N matrix
    private const val M = 10
    private const val N = 10

    // Below arrays details all 4 possible movements from a cell
    private val row = intArrayOf(-1, 0, 0, 1)
    private val col = intArrayOf(0, -1, 1, 0)

    // Function to check if it is possible to go to position (row, col)
    // from current position. The function returns false if (row, col)
    // is not a valid position or has value 0 or it is already visited
    private fun isValid(mat: Array<IntArray>, visited: Array<BooleanArray>, row: Int, col: Int): Boolean {
        return (row >= 0 && row < M && col >= 0 && col < N
                && mat[row][col] == 1 && !visited[row][col])
    }

    // Find Shortest Possible Route in a matrix mat from source
    // cell (i, j) to destination cell (x, y)
    @Suppress("NAME_SHADOWING")
    private fun BFS(mat: Array<IntArray>, i: Int, j: Int, x: Int, y: Int) {
        // construct a matrix to keep track of visited cells
        var i = i
        var j = j
        val visited = Array(M) { BooleanArray(N) }

        // create an empty queue
        val q: Queue<Node> = ArrayDeque()

        // mark source cell as visited and enqueue the source node
        visited[i][j] = true
        q.add(Node(i, j, 0))

        // stores length of longest path from source to destination
        var min_dist = Int.MAX_VALUE

        // loop till queue is empty
        while (!q.isEmpty()) {
            // pop front node from queue and process it
            val node = q.poll()

            // (i, j) represents current cell and dist stores its
            // minimum distance from the source
            i = node.x
            j = node.y
            val dist = node.dist

            // if destination is found, update min_dist and stop
            if (i == x && j == y) {
                min_dist = dist
                break
            }

            // check for all 4 possible movements from current cell
            // and enqueue each valid movement
            for (k in 0..3) {
                // check if it is possible to go to position
                // (i + row[k], j + col[k]) from current position
                if (isValid(mat, visited, i + row[k], j + col[k])) {
                    // mark next cell as visited and enqueue it
                    visited[i + row[k]][j + col[k]] = true
                    q.add(Node(i + row[k], j + col[k], dist + 1))
                }
            }
        }
        if (min_dist != Int.MAX_VALUE) {
            print(
                "The shortest path from source to destination " +
                        "has length " + min_dist
            )
        } else {
            print("Destination can't be reached from given source")
        }
    }

    // Shortest path in a Maze
    @JvmStatic
    fun main(args: Array<String>) {
        // input maze
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

        // Find shortest path from source (0, 0) to
        // destination (7, 5)
        BFS(mat, 0, 0, 7, 5)
    }
}
