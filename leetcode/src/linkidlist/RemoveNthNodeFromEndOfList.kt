package linkidlist

import ListNode

fun main() {

}

// Two pass solution, first find (Size) then delete (Size-n)
fun removeNthFromEnd1(head: ListNode?, n: Int): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head
    var length = 0
    var first = head
    while (first != null) {
        length++
        first = first.next
    }
    length -= n
    first = dummy
    while (length > 0) {
        length--
        first = first!!.next
    }
    first!!.next = first.next!!.next
    return dummy.next
}

// One pass solution using
fun removeNthFromEnd2(head: ListNode?, n: Int): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head
    var first: ListNode? = dummy
    var second: ListNode? = dummy
    // Advances first pointer so that the gap between first and second is n nodes apart
    for (i in 1..n + 1) {
        first = first!!.next
    }
    // Move first to the end, maintaining the gap
    while (first != null) {
        first = first.next
        second = second!!.next
    }
    second!!.next = second.next!!.next
    return dummy.next
}