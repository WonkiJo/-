class Solution {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val angle = getAngle(coordinates[0], coordinates[1])
        for (i in 2 until coordinates.size) {
            if (angle != getAngle(coordinates[0], coordinates[i])) return false
        }
        return true
    }

    fun getAngle(point1: IntArray, point2: IntArray): Int {
        val dy = point2[1] - point1[1]
        if (dy == 0) return 0
        return (point2[0] - point1[0]) / dy
    }
}
