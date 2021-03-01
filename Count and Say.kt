class Solution {
    fun countAndSay(target: Int): String {
        var numbers = StringBuilder("1")
        if (target == 1) return "1"
        if (target > 30) return ""
        for (i in 2..30) {
            val countAndNumberPairs = mutableListOf<Pair<Int, Char>>()
            for (number in numbers.toString().toCharArray()) {
                var pair = countAndNumberPairs.lastOrNull()
                if (pair == null) {
                    val count = 1
                    countAndNumberPairs.add(Pair(count, number))
                } else {
                    if (number == pair.second) {
                        pair.first + 1
                    } else {
                        1
                    }.let { count ->
                        when(count) {
                            1 -> countAndNumberPairs.add(Pair(count, number))
                            else -> countAndNumberPairs[countAndNumberPairs.size - 1] = Pair(count, number)
                        }
                    }
                }
            }

            numbers = StringBuilder()
            for (pair in countAndNumberPairs) {
                numbers.append(pair.first)
                numbers.append(pair.second)
            }

            if (i == target) return numbers.toString()
        }
        return ""
    }
}
