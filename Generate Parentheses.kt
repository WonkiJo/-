class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        val str = "("
        generate(result, n, str, 1, 0)
        return result.toList()
    }
    
    fun generate(result: MutableList<String>, n: Int, str: String, openCount: Int, closeCount: Int) {
        if (str.length == n * 2) {
            result.add(str)
            return
        }
        
        if (openCount == n) {
            generate(result, n, str + ")", openCount, closeCount + 1)
        } else if (openCount == closeCount) {
            generate(result, n, str + "(", openCount + 1, closeCount)
        } else {
            generate(result, n, str + "(", openCount + 1, closeCount)
            generate(result, n, str + ")", openCount, closeCount + 1)
        }
    }
}
