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

    levelOrderBottom(four)

}

fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
    val result: MutableList<MutableList<Int>> = mutableListOf()
    val queue: Queue<TreeNode> = LinkedList()

    if (root == null) return result
    queue.add(root)
    while (queue.isNotEmpty()) {
        val level = mutableListOf<Int>()
        for (i in 0 until queue.size) {
            val current = queue.remove()
            level.add(current.`val`)
            if (current.left != null) queue.add(current.left)
            if (current.right != null) queue.add(current.right)
        }
        result.add(level)
    }
    result.reverse()
    return result
}