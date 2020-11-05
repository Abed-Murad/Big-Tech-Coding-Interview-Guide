package linkidlist

fun main() {

}

fun hasCycle(head: ListNode?): Boolean {
    var walker = head
    var runner = head
    // it will not reach a null tail if it has cycle, if it did, its not a CycleLinkedList.
    while (walker?.next != null && runner?.next != null) {
        runner = runner.next!!.next!!
        walker = walker.next
        if (walker == runner) return true
    }
    return false
}