import kotlin.math.pow
import kotlin.math.ceil

class Solution {
    fun findNthDigit(n: Int): Int {
        var findN = n.toLong()
        for (order in 1..10) {
            val start = 10.toDouble().pow(order - 1).toLong()
            val numOfDigitsInOrder = start * 9 * order
            
            if (findN > numOfDigitsInOrder) {
                findN -= numOfDigitsInOrder
            } else {        
                val offset = ceil(findN / order.toDouble()).toInt()
                val target = start + offset - 1
                val a = target.toString()
                val index = (findN - 1)  % order
                return Character.getNumericValue(a[index.toInt()])
            }
        }
        return 0
    }
}
