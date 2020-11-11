package trees

import TreeNode
import java.util.*

fun main() {

}

fun inorderTraversal(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    inorder(root, list)
    return list
}

fun inorder(node: TreeNode?, list: MutableList<Int>) {
    if (node == null) return
    inorder(node.left, list)
    list.add(node.`val`)
    inorder(node.right, list)
}
