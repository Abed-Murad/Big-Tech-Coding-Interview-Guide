package trees

import TreeNode
import java.util.*


fun main() {
    val root = TreeNode(5)

    val left1 = TreeNode(1)
    val right1 = TreeNode(4)

    val left2 = TreeNode(3)
    val right2 = TreeNode(6)

    root.left = left1
    root.right = right1

    right1.left = left2
    right1.right = right2

    isValidBST(root)

}

// Push All the left values to the stack, then compare them to the next values in a inOrder Traversal.
fun isValidBST(root: TreeNode?): Boolean {
    var root = root
    val stack: Stack<TreeNode?> = Stack<TreeNode?>()
    var inorder = -Double.MAX_VALUE
    while (!stack.isEmpty() || root != null) {
        while (root != null) {
            stack.push(root)
            root = root.left
        }
        root = stack.pop()
        // If next element in inorder traversal
        // is smaller than the previous one
        // that's not BST.
        if (root!!.`val` <= inorder) return false
        inorder = root.`val`.toDouble()
        root = root.right
    }
    return true
}
