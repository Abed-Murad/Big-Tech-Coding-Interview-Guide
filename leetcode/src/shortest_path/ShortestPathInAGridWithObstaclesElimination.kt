package shortest_path

import java.util.*

// Stolen Code, Shame on you(me)!
internal class Solution {
    internal inner class Node(var x: Int, var y: Int, var dist: Int, var obs: Int)

    fun shortestPath(grid: Array<IntArray>, k: Int): Int {
        return BFS(grid, k)
    }

    var row = intArrayOf(-1, 0, 1, 0)
    var col = intArrayOf(0, -1, 0, 1)
    fun BFS(grid: Array<IntArray>, count: Int): Int {
        val n = grid.size
        if (n == 0) {
            return -1
        }
        val m: Int = grid[0].size
        if (m == 0) {
            return -1
        }
        val isVisited = Array(n) { IntArray(m) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                isVisited[i][j] = -1
            }
        }
        val q: Queue<Node> = LinkedList()
        val startNode: Node = Node(0, 0, 0, count)
        q.add(startNode)
        isVisited[0][0] = startNode.obs
        while (!q.isEmpty()) {
            val cur = q.poll()
            if (cur.x == n - 1 && cur.y == m - 1) {
                return cur.dist
            }
            for (k in 0..3) {
                val ti = cur.x + row[k]
                val tj = cur.y + col[k]
                if (isValid(ti, tj, n, m)) {
                    if (isValid(grid, ti, tj)) {
                        if (isValid(isVisited, ti, tj, cur.obs)) {
                            if (cur.x == n - 1 && cur.y == m - 1) {
                                return cur.dist + 1
                            }
                            isVisited[ti][tj] = cur.obs
                            q.add(Node(ti, tj, cur.dist + 1, cur.obs))
                        }
                    } else if (cur.obs > 0) {
                        if (isValid(isVisited, ti, tj, cur.obs - 1)) {
                            if (cur.x == n - 1 && cur.y == m - 1) {
                                return cur.dist + 1
                            }
                            isVisited[ti][tj] = cur.obs - 1
                            q.add(Node(ti, tj, cur.dist + 1, cur.obs - 1))
                        }
                    }
                }
            }
        }
        return -1
    }

    private fun isValid(i: Int, j: Int, n: Int, m: Int): Boolean {
        return i in 0 until n && j >= 0 && j < m
    }

    private fun isValid(grid: Array<IntArray>, i: Int, j: Int): Boolean {
        return grid[i][j] != 1
    }

    private fun isValid(isVisited: Array<IntArray>, i: Int, j: Int, count: Int): Boolean {
        return isVisited[i][j] < count
    }
}