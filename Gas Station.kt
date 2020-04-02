class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var station = 0
        var checker = 0
        var total = 0
        
        gas.forEachIndexed { index, value -> 
            val diff = value - cost[index]
            
            checker += diff
            total += diff
            
            if(checker < 0) {
                checker = 0
                station = index + 1
            }
        }
        
        return if(total >= 0) station else -1
    }
}
