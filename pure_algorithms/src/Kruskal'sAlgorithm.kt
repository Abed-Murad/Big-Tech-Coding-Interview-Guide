import java.util.Comparator

import java.util.Collections

import java.util.Arrays
import java.util.function.ToIntFunction


// Data structure to store graph edges
data class Edge(val src: Int, val dest: Int, val weight: Int) {
    override fun toString(): String {
        return "Edge(src=$src, dest=$dest, weight=$weight)"
    }
}

// class to represent a disjoint set
private class DisjointSet {
    val parent = HashMap<Int, Int>()

    // Preform MakeSet operation
    fun makeSet(n: Int) {
        for (i in 0 until n) {
            parent[i] = i
        }
    }

    // Find the root of the set in which element k belongs
    fun find(k: Int): Int {
        if (parent[k] == k) {
            return k
        }
        // recur for parent until we find root.
        return find(parent[k]!!)
    }

    fun union(a: Int, b: Int) {
        val x = find(a)
        val y = find(b)
        parent[x] = y
    }
}

fun kruskalMST(edges: List<Edge>, n: Int): List<Edge> {
    val MST = arrayListOf<Edge>()
    val ds = DisjointSet()
    ds.makeSet(n)

    var index = 0
    while (MST.size != n - 1) {
        val nextEdge = edges[index++]
        val x = ds.find(nextEdge.src)
        val y = ds.find(nextEdge.dest)
        if (x != y) {
            MST.add(nextEdge)
            ds.union(x, y)
        }
    }
    return MST
}


fun main(args: Array<String>) {
    // (u, v, w) tiplet represent undirected edge from
    // vertex u to vertex v having weight w
    val edges = listOf(
        Edge(0, 1, 7), Edge(1, 2, 8),
        Edge(0, 3, 5), Edge(1, 3, 9),
        Edge(1, 4, 7), Edge(2, 4, 5),
        Edge(3, 4, 15), Edge(3, 5, 6),
        Edge(4, 5, 8), Edge(4, 6, 9),
        Edge(5, 6, 11)
    )

    // sort edges by increasing weight
    Collections.sort(edges, Comparator.comparingInt { (_, _, weight) -> weight })

    // Number of vertices in the graph
    val N = 7

    // construct graph
    val e: List<Edge> = kruskalMST(edges, N)
    for (edge in e) {
        println(edge)
    }
}