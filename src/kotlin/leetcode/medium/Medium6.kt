/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        return findLca(root, p, q)
    }

    private fun findLca(cur: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (cur == null || p == null || q == null) {
            return null
        }

        if (cur.`val` == p.`val` || cur.`val` == q.`val`) {
            return cur
        }

        val node1 = findLca(cur.left, p, q)
        val node2 = findLca(cur.right, p, q)

        if (node1 != null && node2 != null) {
            return cur
        }
        if (node1 == null) {
            return node2
        }
        return node1
    }
}