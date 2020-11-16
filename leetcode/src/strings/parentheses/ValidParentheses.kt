package strings.parentheses

import java.util.*

fun main() {
    isValid("()[]{}")
}

fun isValid(s: String): Boolean {
    val stack1 = Stack<Char>()
    val stack2: Queue<Char> = LinkedList()

    for (char in s) {
        if (char == '(' || char == '[' || char == '{') {
            stack1.add(char)
        } else if (char == ')' || char == ']' || char == '}') {
            if (char == ')') stack2.add('(')
            if (char == ']') stack2.add('[')
            if (char == '}') stack2.add('{')
        }
    }
    if (stack1.size != stack2.size) return false

    for (i in 0 until stack1.size) {
        if (stack1.pop() != stack2.remove()) {
            return false
        }
    }
    return true
}