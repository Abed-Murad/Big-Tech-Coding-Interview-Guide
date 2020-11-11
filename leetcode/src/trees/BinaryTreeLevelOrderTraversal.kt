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

    levelOrder(four)

}

/**
 *    --->>> https://www.youtube.com/watch?v=86g8jAQug04   <<<---
 *    --->>> https://www.youtube.com/watch?v=XZnWETlZZ14   <<<---
 */
fun levelOrder(root: TreeNode?): List<List<Int>> {

    val result: MutableList<MutableList<Int>> = mutableListOf()

    if (root == null) return result

    val queue: Queue<TreeNode> = LinkedList()
    queue.add(root)
    // while there is at least one discovered node
    while (queue.isNotEmpty()) {

        val level: MutableList<Int> = mutableListOf()

        for (i in 0 until queue.size) {
            val node = queue.remove()
            level.add(node.`val`)
            if (node.left != null) queue.add(node.left)
            if (node.right != null) queue.add(node.right)
        }
        result.add(level)
    }
    return result
}