package search


// ****** CHECKOUT THIS LINK FOR MORE DETAILS ---->>>> https://leetcode.com/problems/first-bad-version/
class Solution : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var left = 1
        var right = n
        while (left < right) {
            var mid = left + (right - left) / 2
            if (isBadVersion(mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun isBadVersion(mid: Int): Boolean {
        return false
    }
}

open class VersionControl {

    open fun firstBadVersion(n: Int): Int {
        TODO("Not yet implemented")
    }
}
