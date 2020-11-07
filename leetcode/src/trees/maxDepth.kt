package trees

import TreeNode
import kotlin.math.max

fun main() {

}

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val maxLeft = maxDepth(root.left) + 1
    val maxRight = maxDepth(root.right) + 1
    return Math.max(maxLeft, maxRight)

}