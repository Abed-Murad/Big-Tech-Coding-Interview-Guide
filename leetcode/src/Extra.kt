var node = ListNode(5)
var nodeValue = node.`val`

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "val = $`val`  next.val = ${if (next != null) next!!.`val` else null} "
    }
}


var tree = TreeNode(5)
var treeValue = tree.`val`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

