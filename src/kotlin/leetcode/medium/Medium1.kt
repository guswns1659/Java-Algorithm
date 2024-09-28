package leetcode.medium

// https://leetcode.com/problems/course-schedule/description/
class Solution {
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