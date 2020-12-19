package graph
// A Graph is a data structure that captures relationships between objects
// Types:
// 1. Weighted Graphs: each edge has a weight
// 2. Directed Graphs: n edge may only permit traversal in one direction
// 3. Undirected graphs: a directed graph where all of the edges are bi-directional.

interface Graph<T> {

    fun createVertex(data: T): Vertex<T>

    fun addDirectedEdge(
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?
    )

    fun addUndirectedEdge(
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?
    )

    fun add(
        edge: EdgeType,
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?
    )

    fun edges(source: Vertex<T>): ArrayList<Edge<T>>

    fun weight(
        source: Vertex<T>,
        destination: Vertex<T>
    ): Double?

}

enum class EdgeType {
    DIRECTED, UNDIRECTED
}