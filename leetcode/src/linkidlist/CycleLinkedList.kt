package linkidlist

import java.lang.Exception

fun main() {

}

fun hasCycle(head: ListNode?): Boolean {
    head?.next ?: return false
    var walker = head
    var runner = head

    // it will not reach a null tail if it has cycle, if it did, its not a CycleLinkedList.
    while (runner?.next != null) {
        runner = runner.next?.next
        walker = walker?.next
        if (runner == walker) return true
    }
    return false

}

