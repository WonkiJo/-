class Solution {
     fun numberOfSubstrings(s: String): Int {
        var count = 0
        for (i in 0 .. s.length - 3) {
            val index = findIndexOfCompletedABC(i, s)
            if (index > 0) {
                count += (s.length - index)
                continue
            }
        }
        return count
    }

    private fun findIndexOfCompletedABC(start: Int, s: String): Int {
        var a = false
        var b = false
        var c = false
        for (index in start until s.length) {
            if (a.not()) a = s[index] == 'a'
            if (b.not()) b = s[index] == 'b'
            if (c.not()) c = s[index] == 'c'

            if (a && b && c) {
                return index
            }
        }

        return -1
    }
}
