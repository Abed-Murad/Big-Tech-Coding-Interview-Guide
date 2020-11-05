package linkidlist

fun main() {

}

fun hasCycle(head: ListNode?): Boolean {
    var walker = head
    var runner = head
    while (walker?.next != null && runner?.next?.next != null) {
        runner = runner.next!!.next!!
        walker = walker.next
        if (walker == runner) return true
    }
    return false
}