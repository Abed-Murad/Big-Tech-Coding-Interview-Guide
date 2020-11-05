package tests.line_telent_acquistion_team_2020_11_4

import java.lang.StringBuilder


fun main() {
    hashMap(arrayOf("add 5 3", "add 1 2", "get 5", "evict", "get 1", "remove 5", "exit"))
}

// Solve time = 40,  Score = min 73/300
fun hashMap(n: Array<String>): Array<String> {


    val hashMap = HashMap<String, String>()
    var result = mutableListOf<String>()

    var commands = MutableList<MutableList<String>>(n.size) {
        mutableListOf()
    }
    for (i in n.indices) {
        commands[i] = n[i].split(" ").toMutableList()
    }

    var lastEntry = ""
    var keepGoing = true
    for (i in commands.indices) {
        if (!keepGoing) {
            break
        }
        val command = commands[i]

        if (command[0] == "add") {
            hashMap[command[1]] = command[2]
            lastEntry = command[1]
        } else if (command[0] == "get") {
            val value = hashMap.getOrDefault(command[1], "-1")
            result.add(value)
            lastEntry = command[1]
        } else if (command[0] == "remove") {
            if (hashMap.containsKey(command[1])) {
                val value = hashMap.remove(command[1])
                result.add(value.toString())
            } else {
                result.add((-1).toString())
            }
        } else if (command[0] == "evict") {
            hashMap.remove(lastEntry)
        } else if (command[0] == "exit") {
            keepGoing = false
        }
    }

    return result.toTypedArray()
}


