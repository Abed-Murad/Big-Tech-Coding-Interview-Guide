package linkidlist

fun main() {

}


fun isPalindrome(head: ListNode?): Boolean {
    var fast = head
    var slow = head

    // move fast to the end of the list, move slow to the middle of the list
    while (fast?.next != null) {
        fast = fast.next!!.next
        slow = slow!!.next
    }

    if (fast != null) { // odd nodes: let the right half smaller
        slow = slow!!.next
    }

    // reverse the second half of the list
    slow = reverse(slow)

    while (slow != null) {
        if (fast!!.`val` != slow.`val`) {
            return false
        }
        fast = fast.next
        slow = slow.next
    }
    return true

}

// we move the 'prev' as the new head of the list every time.
fun reverse(mainHead: ListNode?): ListNode? {
    var haed = mainHead
    var prev: ListNode? = null
    while (haed != null) {
        val next = haed.next
        haed.next = prev
        prev = haed
        haed = next
    }
    return prev
}