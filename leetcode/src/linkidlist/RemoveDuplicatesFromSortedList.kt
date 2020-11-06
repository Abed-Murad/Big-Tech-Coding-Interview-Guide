package linkidlist

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(1)
    val node3 = ListNode(2)
    val node4 = ListNode(3)
    val node5 = ListNode(3)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    deleteDuplicates(node1)
}

fun deleteDuplicates(head: ListNode?): ListNode? {
    var current = head
    while (current?.next != null) {
        if (current.`val` == current.next?.`val`) {
            current.next = current.next!!.next
        } else {
            current = current.next
        }
    }
    return head
}