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