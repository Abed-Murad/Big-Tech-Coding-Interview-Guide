// class to represent a disjoint set
class DisjointSet {
    private val parent = HashMap<Int, Int>()

    // perform MakeSet operation
    fun makeSet(universe: IntArray) {
        // create n disjoint sets (one for each item)
        for (i in universe) parent[i] = i
    }

    // Find the root of the set in which element k belongs
    fun find(k: Int): Int {
        // if k is root
        return if (parent[k] == k) k else find(parent[k]!!)
        // recur for parent until we find root
    }

    // Perform Union of two subsets
    fun union(a: Int, b: Int) {
        // find root of the sets in which elements
        // x and y belongs
        val x = find(a)
        val y = find(b)
        parent[x] = y
    }

}

fun printSets(universe: IntArray, ds: DisjointSet) {
    for (i in universe) print(ds.find(i).toString() + " ")
    println()
}

fun main(args: Array<String>) {
    // universe of items
    val universe = intArrayOf(1, 2, 3, 4, 5)

    // initialize DisjointSet class
    val ds = DisjointSet()

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