package linkidlist

fun main() {

}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val start = ListNode(0)
    var slow: ListNode? = start
    var fast: ListNode? = start
    slow!!.next = head

    //Move fast in front so that the gap between slow and fast becomes n
    for (i in 1..n + 1) {
        fast = fast!!.next
    }
    //Move fast to the end, maintaining the gap
    while (fast != null) {
        slow = slow!!.next
        fast = fast.next
    }
    //Skip the desired node
    slow!!.next = slow.next!!.next
    return start.next
}