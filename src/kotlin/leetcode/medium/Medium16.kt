package leetcode.medium

import java.util.*

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

// https://leetcode.com/problems/top-k-frequent-elements/
fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val freqMap = nums.toList().groupingBy { it }.eachCount()  // Group and count elements in one line.
    val pq = PriorityQueue<Map.Entry<Int, Int>>(compareBy { it.value })

    for (entry in freqMap.entries) {
        pq.add(entry)
        if (pq.size > k) pq.poll()  // 빈도수 계산은 힙에 맡긴다. 내가 하지 않는다.
    }

    return pq.map { it.key }.toIntArray()  // Collect the result.
}


fun main() {
    print(topKFrequent(intArrayOf(1,1,1,2,2,3), 2).toList())
}
