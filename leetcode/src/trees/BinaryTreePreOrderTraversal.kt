package trees

import TreeNode
import java.util.*


fun main() {
    val one = TreeNode(1)
    val two = TreeNode(2)
    val three = TreeNode(3)
    val four = TreeNode(4)
    val five = TreeNode(5)
    val six = TreeNode(6)
    val seven = TreeNode(7)

    four.left = two
    four.right = six

    two.left = one
    two.right = three

    six.left = five
    six.right = seven

    preorderTraversal(four)

}


fun preorderTraversal(root: TreeNode?): List<Int> {
    val list: MutableList<Int> = mutableListOf()
    preOrderRecursive(root, list)
    return list
}

// recursive
fun preOrderRecursive(node: TreeNode?, list: MutableList<Int>) {
    if (node == null) return
    list.add(node.`val`)
    preOrderRecursive(node.left, list)
    preOrderRecursive(node.right, list)
}

fun preOrderIteratively(root: TreeNode?): List<Int> {
    val stack = LinkedList<TreeNode>()
    val result = mutableListOf<Int>()
    if (root == null) return result

    stack.push(root)
    while (stack.isNotEmpty()) {
        val node = stack.pop()
        result.add(node.`val`)
        if (node.right != null) stack.push(node.right)
        if (node.left != null) stack.push(node.left)
    }
    return result
}