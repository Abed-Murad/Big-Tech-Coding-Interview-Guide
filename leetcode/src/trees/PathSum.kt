package trees

import TreeNode

fun main() {
    hasPathSum(TreeNode(1), 1)
}

fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
    if (root == null) return false
    if (root.left == null && root.right == null && sum - root.`val` == 0) {
        return true
    } else {
        return hasPathSum(root.left, sum - root.`val`) || hasPathSum(root.right, sum - root.`val`)
    }
}