package my_data_structures

/**
 * This Implementation is based on this video (Data Structures: Trees) [https://www.youtube.com/watch?v=oSWTXtMglKE]
 *
 */

class Node(var right: Node? = null, var left: Node? = null, var data: Int = 0) {

    fun insert(value: Int) {
        if (value < data) {
            if (left != null) {
                left!!.insert(value)
            } else {
                left = Node(data = value)
            }
        } else {
            if (right != null) {
                right!!.insert(value)
            } else {
                right = Node(data = value)
            }
        }
    }


    fun contains(value: Int): Boolean {
        if (value == data) {
            return true
        } else if (value < data) {
            if (left == null) {
                return false
            } else {
                return left!!.contains(value)
            }
        } else {
            if (right == null) {
                return false
            } else {
                return right!!.contains(value)
            }
        }
    }

    fun printInOrder() {                         // A -> B -> C
        left?.printInOrder()    // 1
        print(data)             // 2
        right?.printInOrder()   // 3
    }

    fun printPreOrder() {                       // B -> A -> C
        print(data)             // 2
        left?.printPreOrder()   // 1
        right?.printPreOrder()  // 3
    }

    fun printPostOrder() {                      // A -> C -> B
        left?.printPostOrder()  // 1
        right?.printPostOrder() // 3
        print(data)             // 2
    }


}
