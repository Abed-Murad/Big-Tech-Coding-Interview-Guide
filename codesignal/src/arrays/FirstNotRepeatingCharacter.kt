package arrays

fun main() {
    firstNotRepeatingCharacter("abacabad")
    firstNotRepeatingCharacter("abcdefghijklmnopqrstuvwxyziflskecznslkjfabe")
    firstNotRepeatingCharacter("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof")
}

fun firstNotRepeatingCharacter(s: String): Char {
    val counter = IntArray(26)
    for (char in s)
        counter[char - 'a']++
    for (char in s) {
        if (counter[char - 'a'] == 1)
            return char
    }
    return '_'
}
