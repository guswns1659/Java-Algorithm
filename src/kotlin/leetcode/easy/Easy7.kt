package leetcode.easy

// https://leetcode.com/problems/isomorphic-strings/
class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val map1 = mutableMapOf<Char, Char>()
        val map2 = mutableMapOf<Char, Char>()

        for (i in s.indices) {
            val c1 = s[i]
            val c2 = t[i]

            if (map1[c1] == null && map2[c2] == null) {
                map1[c1] = c2
                map2[c2] = c1
            } else {
                if (map1[c1] != c2 || map2[c2] != c1) {
                    return false
                }
            }
        }
        return true
    }
}


// https://leetcode.com/problems/non-decreasing-array/
class Solution2 {
    fun checkPossibility(nums: IntArray): Boolean {
        var count = 0

        for (i in 0 until nums.size - 1) {
            if (nums[i] > nums[i+1]) {
                if (count > 0) return false
                count++
                if (i == 0 || nums[i-1] <= nums[i+1]) { // i - 1의 값이 i + 1 보다 작거나 같으면 i를 i+1 값으로 변경해야 유리
                    nums[i] = nums[i+1]
                } else {
                    nums[i+1] = nums[i]
                }
            }
        }

        return true
    }
}

// https://leetcode.com/problems/invert-binary-tree/
// 내가 푼 큐
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.

 */
class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
}

class Solution3 {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val q = mutableListOf<TreeNode?>()
        q.add(root)

        while (q.isNotEmpty()) {
            val current = q.removeAt(0) // 큐에서 값을 제거
            if (current != null) {
                swap(current)
                if (current.left != null) q.add(current.left)
                if (current.right != null) q.add(current.right)
            }
        }

        return root
    }

    private fun swap(current: TreeNode) {
        val temp = current.left
        current.left = current.right
        current.right = temp
    }
}

// gpt 재귀
fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    val left = invertTree(root.left)
    val right = invertTree(root.right)
    root.left = right
    root.right = left
    return root
}

// https://leetcode.com/problems/count-primes/description/
fun countPrimes(n: Int): Int {
    // n이 2 이하인 경우 소수가 없으므로 바로 0을 반환
    if (n <= 2) return 0

    // 모든 숫자가 소수라고 가정하고 Boolean 배열을 true로 초기화
    val isPrime = BooleanArray(n) { true }
    isPrime[0] = false // 0은 소수가 아님
    isPrime[1] = false // 1도 소수가 아님

    // 2부터 n의 제곱근까지 탐색하면서 소수의 배수를 제거
    for (i in 2 until Math.sqrt(n.toDouble()).toInt() + 1) {
        // i가 소수인 경우에만 배수 제거 작업을 수행
        if (isPrime[i]) {
            // i의 배수들을 false로 설정하여 소수가 아님을 표시
            // i * i부터 시작하는 이유는 그 이전 배수들은 이미 처리되었기 때문
            for (j in i * i until n step i) {
                isPrime[j] = false
            }
        }
    }

    // 남아있는 true 값들의 개수를 세어 소수의 개수를 반환
    return isPrime.count { it }
}

// https://leetcode.com/problems/longest-continuous-increasing-subsequence/
class Solution5 {
    fun findLengthOfLCIS(nums: IntArray): Int {
        var largest = 1
        var length = 1
        for (i in nums.indices) {
            if (i >= nums.size - 1) return largest

            if (nums[i] < nums[i+1]) {
                length += 1
            } else {
                if (largest < length) largest = length
                else length = 1
            }
        }
        return largest
    }
}

class ListNode {
    var next: ListNode? = null
}

// hashSet 방식
class Solution4 {
    fun hasCycle(head: ListNode?): Boolean {
        val visitedNodes = mutableSetOf<ListNode>()

        var current = head
        while (current != null) {
            if (visitedNodes.contains(current)) {
                return true
            }
            visitedNodes.add(current)
            current = current.next
        }

        return false
    }
}

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution6 {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return sortRecursive(nums, 0, nums.size - 1)
    }

    private fun sortRecursive(nums: IntArray, left: Int, right: Int): TreeNode? {
        if (left > right) return null
        val mid = left + (right - left) / 2

        val node = TreeNode(nums[mid])
        node.left = sortRecursive(nums, left, mid - 1)
        node.right = sortRecursive(nums, mid + 1, right)

        return node
    }
}

// https://leetcode.com/problems/merge-two-binary-trees/
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution7 {
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        return mergeRecursive(root1, root2)
    }

    private fun mergeRecursive(left: TreeNode?, right: TreeNode?): TreeNode? {
        if (left == null && right == null) return null

        val value = (left?.`val` ?: 0) + (right?.`val` ?: 0)
        val node = TreeNode(value)
        node.left = mergeRecursive(left?.left, right?.left)
        node.right = mergeRecursive(left?.right, right?.right)

        return node
    }
}



