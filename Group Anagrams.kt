class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val results = mutableMapOf<String, MutableList<String>>()
        for (str in strs) {
            val arr = str.toCharArray()
            val key = arr.sorted().joinToString("")
            results.getOrPut(key) { mutableListOf() }.add(str)
        }
        return results.values.map { it.toList() }.toList()
    }
}
