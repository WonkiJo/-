/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun distanceK(root: TreeNode?, target: TreeNode?, K: Int): List<Int> {
        val result = mutableListOf<Int>()
        find(result, root, target, K)
        return result
    }
    
    fun find(result: MutableList<Int>, root: TreeNode?, target: TreeNode?, k: Int) {
        if (root?.`val` == target?.`val`) {
            // k가 0이면 루트 노드를 추가, 아니면 k만큼 더 뎁스가 큰 노드들을 추가.
            if (k == 0) {
                result.add(root!!.`val`)
            } else {
                findNodeValue(result, root?.left, k, 1)
                findNodeValue(result, root?.right, k, 1)
            }
        } else {
            val left = findTargetDepth(root?.left, target, 1)
            val right = findTargetDepth(root?.right, target, 1)
            
            if (left == -1 && right == -1) {
                // 이 밑으로는 타겟이 없음
            } else {
                if (left > 0) {
                    // 왼쪽에 있음, 오른쪽으로 타겟과의 거리를 뺀 뎁스의 노드들을 추가, 그리고 왼쪽으로 계속 탐색
                    if (k - left == 0) {
                        result.add(root!!.`val`)
                        find(result, root?.left, target, k)
                    } else {
                        findNodeValue(result, root?.right, k - left, 1)
                        find(result, root?.left, target, k)
                    }
                } else if (right > 0) {
                    // 오른쪽에 있음, 왼쪽으로 타겟과의 거리를 뺀 뎁스의 노드들을 추가, 그리고 오른쪽으로 계속 탐색
                    if (k - right == 0) {
                        result.add(root!!.`val`)
                        find(result, root?.right, target, k)
                    } else {
                        findNodeValue(result, root?.left, k - right, 1)
                        find(result, root?.right, target, k)
                    }
                }
            }
        }
    }
    
    fun findTargetDepth(check: TreeNode?, target: TreeNode?, depth: Int): Int {
        if (check?.`val` == target?.`val`) {
            return depth
        } else {
            if (check?.left == null && check?.right == null) {
                return -1
            } else {
                if (check.right == null) {
                    return findTargetDepth(check?.left, target, depth + 1)
                } else if (check.left == null) {
                    return findTargetDepth(check?.right, target, depth + 1)
                } else {
                    val left = findTargetDepth(check?.left, target, depth + 1)
                    val right = findTargetDepth(check?.right, target, depth + 1)
                    if (left == -1 && right == -1) {
                        return -1
                    } else {
                        return if (left > right) left else right
                    }
                }
            }
        }
    }
    
    fun findNodeValue(result: MutableList<Int>, root: TreeNode?, targetDepth: Int, depth: Int) {
        if (root == null || targetDepth < 0) {
            
        } else {
            if (targetDepth == depth) {
                result.add(root!!.`val`)
            } else {
                findNodeValue(result, root?.left, targetDepth, depth + 1)
                findNodeValue(result, root?.right, targetDepth, depth + 1)
            }
        }
    }
}
