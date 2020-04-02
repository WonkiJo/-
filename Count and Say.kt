class Solution {
    fun countAndSay(n: Int): String {
        var result = StringBuilder("1")
        if (n == 1) return "1"
        if (n > 30) return ""
        for (i in 2..30) {
            val list = mutableListOf<Pair<Int, Char>>()
            for (c in result.toString().toCharArray()) {
                var pair = list.lastOrNull()
                if (pair == null) {
                    list.add(Pair(1, c))
                } else {
                    if (c == pair.second) {
                        list[list.size - 1] = Pair(pair.first + 1, c)
                    } else {
                        list.add(Pair(1, c))
                    }
                }
            }

            result = StringBuilder()
            for (pair in list) {
                result.append(pair.first)
                result.append(pair.second)
            }

            if (i == n) return result.toString()
        }
        return ""
    }
}
