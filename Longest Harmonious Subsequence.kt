class Solution {
    fun findLHS(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        nums.sort()
        var result = 0
        for (i in nums) {
            val count = nums.count { it == i }
            val count2 = nums.count { it == i + 1 }
            val subResult = if (count == 0 || count2 == 0) {
                0
            } else {
                count + count2
            }
            if (subResult > result) {
                result = subResult
            }
        }
        return result
    }
}
