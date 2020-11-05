package linkidlist

fun main() {
    val node11 = ListNode(1)
    val node12 = ListNode(2)
    val node13 = ListNode(4)
    node11.next = node12
    node12.next = node13

    val node21 = ListNode(1)
    val node22 = ListNode(3)
    val node23 = ListNode(4)
    node21.next = node22
    node22.next = node23


    mergeTwoLists(node11 , node12)
}


fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var result: ListNode? = ListNode(0)
    var current = result

    var firstNode = l1
    var secondNode = l2

    while (firstNode != null || secondNode != null) {
        if (firstNode == null) {
            current?.next = secondNode;break
        }
        if (secondNode == null) {
            current?.next = firstNode;break
        }
        if (firstNode.`val` < secondNode.`val`) {
            current?.next = firstNode
            firstNode = firstNode.next
        } else {
            current?.next = secondNode
            secondNode = secondNode.next
        }

        current = current?.next
    }
    return result?.next

}