package linkidlist


var li = ListNode(5)
var v = li.`val`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "val = $`val`  next.val = ${if (next != null) next!!.`val` else null} "
    }
}

