// class to represent a disjoint set
class DisjointSetClassic {
    private val parent = HashMap<Int, Int>()

    // stores the depth of trees
    private val rank = HashMap<Int, Int>()

    // perform MakeSet operation
    fun makeSet(universe: IntArray) {
        // create n disjoint sets (one for each item)
        for (i in universe) {
            parent[i] = i
            rank[i] = 0
        }
    }

    // Find the root of the set in which element k belongs
    fun find(k: Int): Int {
        // if k is not root
        if (parent[k] != k) // path compression
            parent[k] = find(parent[k]!!)
        return parent[k]!!
    }

    // Perform Union of two subsets
    fun union(a: Int, b: Int) {
        // find root of the sets in which elements
        // x and y belongs
        val x = find(a)
        val y = find(b)

        // if x and y are present in same set
        if (x == y) return

        // Always attach a smaller depth tree under the
        // root of the deeper tree.
        if (rank[x]!! > rank[y]!!) parent[y] = x else if (rank[x]!! < rank[y]!!) parent[x] = y else {
            parent[x] = y
            rank[y] = rank[y]!! + 1
        }
    }

}

fun printSets(universe: IntArray, ds: DisjointSetClassic) {
    for (i in universe) print(ds.find(i).toString() + " ")
    println()
}

fun main(args: Array<String>) {
    // universe of items
    val universe = intArrayOf(1, 2, 3, 4, 5)

    // initialize DisjointSet class
    val ds = DisjointSetClassic()

    // create singleton set for each element of universe
    ds.makeSet(universe)
    printSets(universe, ds)
    ds.union(4, 3) // 4 and 3 are in same set
    printSets(universe, ds)
    ds.union(2, 1) // 1 and 2 are in same set
    printSets(universe, ds)
    ds.union(1, 3) // 1, 2, 3, 4 are in same set
    printSets(universe, ds)
}


// Notes
//  1. The Union-Find Algorithm is used in the Disjoint-Set Data Structure.
//  2. Disjoint Set: A group of set where no item can be in more than one set.