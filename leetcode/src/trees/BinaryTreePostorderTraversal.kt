package trees

import TreeNode
import java.util.*

fun main() {

}

fun postorderTraversal(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    if (root == null) return list
    postOrder(root, list)
    return list
}

fun postOrder(root: TreeNode?, list: MutableList<Int>) {
    if (root == null) return
    postOrder(root.left, list)
    postOrder(root.right, list)
    list.add(root.`val`)
}


