package linkidlist

fun main() {
    val node1 = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    reverseListIterative(node1)
}

fun reverseListIterative(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    var traverseNode = head
    var newHead = head

    while (traverseNode.next != null) {

        var tmpNode = traverseNode.next
        traverseNode.next = traverseNode.next?.next

        val tmpHead = newHead
        newHead = tmpNode
        newHead!!.next = tmpHead
    }
    return newHead
}

fun reverseListRecursive(head: ListNode?): ListNode? {
    return head?.next?.let {
        reverseListRecursive(it).apply {
            head.next!!.next = head
            head.next = null
        }
    } ?: head
}


fun reverseList2(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr = head
    while (curr != null) {
        val nextTemp = curr.next
        curr.next = prev
        prev = curr
        curr = nextTemp
    }
    return prev
}
fun reverseList(head: ListNode?): ListNode? {
    if (head?.next == null) return head
    val p = reverseList(head.next)
    head.next!!.next = head
    head.next = null
    return p
}


