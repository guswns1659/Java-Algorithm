package leetcode.medium

import java.util.*

// https://leetcode.com/problems/course-schedule/description/
class Solution0 {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adj = Array(numCourses) { mutableListOf<Int>() }
        val color = IntArray(numCourses) { WHITE }

        // 그래프 만들기
        for (pre in prerequisites) {
            adj[pre[1]].add(pre[0])
        }

        // 모든 코스에 대해 DFS로 사이클 확인
        for (i in 0 until numCourses) {
            if (color[i] == WHITE && hasCycle(adj, i, color)) {
                return false
            }
        }

        return true
    }

    // DFS로 사이클 탐지
    private fun hasCycle(adj: Array<MutableList<Int>>, node: Int, color: IntArray): Boolean {
        color[node] = GRAY
        for (neighbor in adj[node]) {
            if (color[neighbor] == GRAY) {
                return true // 사이클 발견
            }
            if (color[neighbor] == WHITE && hasCycle(adj, neighbor, color)) {
                return true
            }
        }
        color[node] = BLACK
        return false
    }

    companion object {
        private const val WHITE = 0
        private const val GRAY = 1
        private const val BLACK = 2
    }
}

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
class Solution1 {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1

        while (l <= r) {
            val mid = l + (r - l ) / 2

            if (nums[mid] == target) return mid

            // 왼쪽 배열이 오름차순인지 확인
            if (nums[l] <= nums[mid]) {
                // 목표 값이 이 정렬된 구간에 있는지 확인
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1
                } else {
                    l = mid + 1 // mid는 이미 7번 라인에서 체크했으니 +1 해준다
                }
            } else {
                // 목표 값이 이 오른쪽 부분에 있는지 확인
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            }

        }
        return -1
    }
}

// https://leetcode.com/problems/number-of-islands/
class Solution2 {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0

        val rows = grid.size
        val cols = grid[0].size
        var count = 0

        fun dfs(r: Int, c: Int) {
            if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') return
            grid[r][c] = '0'  // Mark the cell as visited
            dfs(r + 1, c)  // Explore down
            dfs(r - 1, c)  // Explore up
            dfs(r, c + 1)  // Explore right
            dfs(r, c - 1)  // Explore left
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (grid[r][c] == '1') {
                    count++
                    dfs(r, c)  // Start a DFS to mark the entire island
                }
            }
        }

        return count
    }
}

// https://leetcode.com/problems/merge-intervals/
fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return emptyArray()

    // Step 1: Sort intervals by their start times
    intervals.sortBy { it[0] }

    // Step 2: Initialize a list to store the merged intervals
    val merged = mutableListOf<IntArray>()

    // Step 3: Iterate through the intervals
    for (interval in intervals) {
        // If merged list is empty or current interval does not overlap with the last one
        if (merged.isEmpty() || merged.last()[1] < interval[0]) {
            // Add the current interval to the merged list
            merged.add(interval)
        } else {
            // There is an overlap, merge the intervals by updating the end time
            merged.last()[1] = maxOf(merged.last()[1], interval[1])
        }
    }

    // Step 4: Convert the result back to an array and return
    return merged.toTypedArray()
}

// https://leetcode.com/problems/binary-tree-level-order-traversal/?envType=problem-list-v2&envId=xixy4dq7
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

class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
}

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        var list = mutableListOf<Int>()
        if (root == null) {
            return result
        }

        // current level
        var cl = 0

        val q = LinkedList<Pair<TreeNode, Int>>()
        q.add(root to cl)

        while (q.isNotEmpty()) {
            val pair = q.poll()
            val now = pair.first
            val newCl = pair.second + 1

            if (cl == pair.second) {
                list.add(pair.first.`val`)
            } else {
                result.add(list)
                list = mutableListOf() // clear()하면 result에 들어간 list 초기화..
                cl++
                list.add(pair.first.`val`)
            }

            pair.first.left?.let {
                q.add(it to newCl)
            }
            pair.first.right?.let {
                q.add(it to newCl)
            }
        }

        result.add(list)  // 마지막 레벨의 리스트 추가

        return result
    }
}
