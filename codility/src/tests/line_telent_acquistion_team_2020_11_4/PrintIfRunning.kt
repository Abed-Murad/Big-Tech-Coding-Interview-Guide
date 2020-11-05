package tests.line_telent_acquistion_team_2020_11_4

import java.util.*
import kotlin.collections.HashMap
import kotlin.math.log

fun main() {

}

fun printIfRunning(t: Int, logs: Array<String>): String {
    val map = HashMap<String, String>()

    val logsList = MutableList<MutableList<String>>(logs.size) {
        mutableListOf()
    }

    for (i in logs.indices) {
        logsList[i] = logs[i].split(" ").toMutableList()
    }


    for (log in logsList) {
        if (log[0].toInt() >= t) {
            break
        }
        map[log[1]] = log[2]
    }
    var processFound = false
    var result = "-1"
    for (mutableEntry in map) {
        if (mutableEntry.value == "running") {
            result = mutableEntry.key
            processFound = true
        }
    }
    if (!processFound) {
        println("-1")
    }

    return result
}