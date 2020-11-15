package design

import java.util.*
import kotlin.math.min

fun main() {

}

class MinStack() {

    /** initialize your data structure here. */
    val stack = Stack<Int>()
    val minStack = Stack<Int>()
    fun push(x: Int) {
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x)
        }
        stack.push(x)
    }

    fun pop() {
        if (stack.peek() == minStack.peek()) {
            minStack.pop()
        }
        stack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }

}

