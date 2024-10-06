package leetcode.medium

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
    if (inorder.isEmpty()) return null

    return findRoot(inorder, postorder)
}

fun findRoot(inorder: IntArray, postorder: IntArray): TreeNode? {
    if (inorder.isEmpty()) return null

    val root = postorder.last()
    val rootIndex = inorder.indexOf(root)
    val node = TreeNode(root)
    node.left = findRoot(inorder.sliceArray(0 until rootIndex), postorder.sliceArray(0 until rootIndex))
    node.right = findRoot(postorder.sliceArray(rootIndex+1 until inorder.size), postorder.sliceArray(rootIndex until postorder.lastIndex ))

    return node
}
