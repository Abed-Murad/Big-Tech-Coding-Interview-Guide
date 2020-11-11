package trees

import TreeNode

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


}

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    return helper(nums, 0, nums.size - 1)
}

fun helper(nums: IntArray, start: Int, end: Int): TreeNode? {
    if (start > end) return null
    val i = (end + start) / 2

    val node = TreeNode(nums[i])

    node.left = helper(nums, start, i - 1)
    node.right = helper(nums, i + 1, end)

    return node
}