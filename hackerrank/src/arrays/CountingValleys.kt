package arrays

fun main() {
    countingValleys(8, "UDDDUDUU")
}

fun countingValleys(steps: Int, path: String): Int {
    var valleyCount = 0
    var seaLevel = 0

    for (char in path) {
        if (char == 'U') {
            seaLevel++
            if (seaLevel == 0) {
                valleyCount++
            }
        } else {
            seaLevel--
        }
    }
    return valleyCount
}