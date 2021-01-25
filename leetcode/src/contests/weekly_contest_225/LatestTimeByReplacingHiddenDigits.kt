package contests.weekly_contest_225

import java.lang.StringBuilder

fun maximumTime(time: String): String? {
    val times = time.toCharArray()
    if (times[0] == '?') {
        times[0] = if (times[1] <= '3' || times[1] == '?') '2' else '1'
    }
    if (times[1] == '?') {
        times[1] = if (times[0] == '2') '3' else '9'
    }

    if (times[3] == '?') {
        times[3] = '5'
    }

    if (times[4] == '?') {
        times[4] = '9'
    }
    return String(times)

}

fun main() {
    maximumTime("2?:?0")
    maximumTime("0?:3?")
    maximumTime("1?:22")
}