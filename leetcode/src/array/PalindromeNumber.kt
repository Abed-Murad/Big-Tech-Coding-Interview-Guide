package array

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        val list = getDigitsArray(x)
        var start = 0
        var end = list.size - 1
        while(start < end){
            if(list[start] != list[end]){
                return false
            }
            start++
            end--
        }
        return true
    }

    private fun getDigitsArray(number:Int):ArrayList<Int>{
        val array = arrayListOf<Int>()
        var remains = number
        while(remains > 0){
            var mostRightDigit = remains % 10
            remains = remains/10
            array.add(mostRightDigit)
        }
        return array
    }
}