class Solution {
    fun commonChars(A: Array<String>): List<String> {
      val result = mutableListOf<String>()
      val map = HashMap<Char, Int>(26)
      for (c in 'a'..'z') {
          val list = mutableListOf<Int>()
          for (a in A) {
              list.add(a.count { it == c })
          }
          val minCount = list.min() ?: 0
          if (minCount > 0) {
              map[c] = minCount
          }
      }
      for (key in map.keys) {
          for (i in 0 until (map[key] ?: 0)) {
              result.add(key.toString())
          }
      }
      return result.toList()
  }
}
