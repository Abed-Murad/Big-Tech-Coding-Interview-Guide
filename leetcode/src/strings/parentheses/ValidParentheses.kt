package strings.parentheses

import java.util.*
import kotlin.collections.HashMap

val map = HashMap<Char, Char>()  // Hash table that takes care of the mappings.

fun main() {
    map[')'] = '('
    map['}'] = '{'
    map[']'] = '['

    isValid("()[]{}")
}


fun isValid(s: String): Boolean {
    val stack = Stack<Char>()

    for (char in s) {
        // if the current char is a closing bracket.
        if (map.contains(char)) {
            // Get the top element of the stack. if the stack is empty, set a dummy value of '#'
            val top = if (stack.empty()) '#' else stack.pop()
            // if the mapping for this bracket doesn't match the stack's top element, return false.
            if (top != map[char]) {
                return false
            }
        } else {
            // If it was an opening bracket, push to the stack.
            stack.push(char)
        }
    }
    return stack.empty()
}