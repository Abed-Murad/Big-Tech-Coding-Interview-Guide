package linkidlist

fun main() {
    val node1 = ListNode(4)
    val node2 = ListNode(5)
    node1.next = node2
    val node3 = ListNode(1)
    node2.next = node3
    val node4 = ListNode(9)
    node3.next = node4

    deleteNode(node2)
}
// we have to replace the value of the node we want to delete with the value in the node after it,
// and then delete the node after it.
// Time and space complexity are both O(1).
fun deleteNode(node: ListNode?) {
    node?.`val` = node?.next?.`val`!!
    node.next = node.next?.next
}