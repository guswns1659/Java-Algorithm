package data_structure

class TreeNode(var data: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class BinarySearchTree {
    var root: TreeNode? = null

    fun delete(value: Int) {
        root = deleteRec(value, root)

    }

    private fun deleteRec(value: Int, cur: TreeNode?): TreeNode? {
        if (cur == null) {
            return null
        }

        if (cur.data > value) {
            cur.left = deleteRec(value, cur.left)
        } else if (cur.data < value) {
            cur.right = deleteRec(value, cur.right)
        } else {
            if (cur.left == null && cur.right == null) {
                return null
            }
            if (cur.left == null) {
                return cur.right
            }
            if (cur.right == null) {
                return cur.left
            }
            val smallest = findSmallest(cur.right!!)
            cur.data = smallest
            cur.right = deleteRec(smallest, cur.right)
        }
        return cur
    }

    private fun findSmallest(cur: TreeNode): Int {
        return cur.left?.let { findSmallest(it) } ?: cur.data
    }
}