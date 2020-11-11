package trees

import TreeNode

fun main() {

}

// Time complexity = O(N), Space complexity = O(N)
fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    val temp = root.left
    root.left = root.right
    root.right = temp
    invertTree(root.left)
    invertTree(root.right)
    return root
}

//TODO: Solve it Iteratively!