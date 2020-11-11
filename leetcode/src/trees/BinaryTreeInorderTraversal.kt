package trees

import TreeNode
import array.matreices.rotate
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

    inorderTraversalIterating(four)

}

fun inorderTraversal(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    inorder(root, list)
    return list
}

// Time complexity = O(n)
// Space complexity = O(n)
fun inorder(node: TreeNode?, list: MutableList<Int>) {
    if (node == null) return
    inorder(node.left, list)
    list.add(node.`val`)
    inorder(node.right, list)
}


// Time complexity = O(n)
// Space complexity = O(n)
// check out for good illustrations https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
fun inorderTraversalIterating(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    if (root == null) return list
    val stack = LinkedList<TreeNode>()

    var current = root
    while (current != null || stack.isNotEmpty()) {
        // discover loop to discover if there is any undiscovered nodes
        while (current != null) {
            stack.push(current)
            current = current.left
        }
        current = stack.pop() // Adding values to the list to be returned.
        list.add(current.`val`)
        current = current.right
    }
    return list
}

