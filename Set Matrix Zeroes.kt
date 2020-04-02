class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val coords = mutableSetOf<Pair<Int, Int>>()
        
        val colSize = matrix.size
        val rowSize = matrix[0].size
        
        for (col in 0 until colSize) {
            for (row in 0 until rowSize) {
                if (matrix[col][row] == 0) {
                    coords.add(Pair(col, row))
                }
            }
        }
        
        for (coord in coords) {
            val targetCol = coord.first
            val targetRow = coord.second
            
            for (row in targetRow - 1 downTo 0) {                
                matrix[targetCol][row] = 0
            }
            
            for (row in targetRow + 1 until rowSize) {
                matrix[targetCol][row] = 0
            }
            
            for (col in targetCol - 1 downTo 0) {
                matrix[col][targetRow] = 0
            }
            
            for (col in targetCol + 1 until colSize) {
                matrix[col][targetRow] = 0
            }
        }
    }
}
