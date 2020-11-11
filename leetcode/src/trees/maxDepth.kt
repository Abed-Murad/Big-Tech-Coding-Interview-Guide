package trees

import TreeNode
import kotlin.math.max

fun main() {

}

// This is a bottom-up recursive solution..
// Checkout https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/534/
fun maxDepth(root: TreeNode?): Int {
    return if (root == null) 0 else maxOf(maxDepth(root.left), maxDepth(root.right)) + 1
}