package leetcode.medium.review

import java.util.*


// https://leetcode.com/problems/permutations/
fun permute(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()
    val cur = mutableListOf<Int>()
    val visited = BooleanArray(nums.size) { false }

    fun b() {
        if (cur.size == nums.size) {
            result.add(cur.toMutableList())
            return
        }

        for (i in nums.indices) {
            if (visited[i]) {
                continue;
            }
            cur.add(nums[i])
            visited[i] = true
            b()
            visited[i] = false
            cur.removeAt(cur.size - 1)
        }
    }

    b()
    return result
}

// https://leetcode.com/problems/course-schedule/description/
fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val adj = Array(numCourses) { mutableListOf<Int>() }
    val colors = IntArray(numCourses) { 0 }

    for (pre in prerequisites) {
        adj[pre[1]].add(pre[0])
    }

    for (i in 0 until numCourses) {
        if (colors[i] == 0 && hasCycle(adj, i, colors)) {
            return false
        }
    }

    return true
}

fun hasCycle(adj: Array<MutableList<Int>>, node: Int, colors: IntArray): Boolean {
    colors[node] = 1
    for (neighbor in adj[node]) {
        if (colors[neighbor] == 1) {
            return true
        }
        if (colors[neighbor] == 0 && hasCycle(adj, neighbor, colors)) {
            return true
        }
    }
    colors[node] = 2
    return false
}

// https://leetcode.com/problems/course-schedule/description/
fun canFinish2(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val adj = Array(numCourses) { mutableListOf<Int>() }
    val colors = IntArray(numCourses) { 0 }

    for (pre in prerequisites) {
        adj[pre[1]].add(pre[0])
    }

    for (i in 0 until numCourses) {
        if (colors[i] == 0 && hasCycle(adj, i, colors)) {
            return false
        }
    }

    return true
}

fun hasCycle2(adj: Array<MutableList<Int>>, node: Int, colors: IntArray): Boolean {
    colors[node] = 1
    for (neighbor in adj[node]) {
        if (colors[neighbor] == 1) {
            return true
        }
        if (colors[neighbor] == 0 && hasCycle(adj, neighbor, colors)) {
            return true
        }
    }
    colors[node] = 2
    return false
}

// https://leetcode.com/problems/top-k-frequent-elements/description/
fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val map = nums.toList().groupingBy { it }.eachCount()
    val pq = PriorityQueue<Map.Entry<Int, Int>> ( compareBy {it.value} )

    for (i in map) {
        pq.add(i)
        if (pq.size > k) pq.poll()
    }

    return pq.map { it.key }.toIntArray()
}


fun main() {
    println(topKFrequent(intArrayOf(1,1,1,2,2,3), 2).forEach {println(it)})
    println(topKFrequent(intArrayOf(1), 1).forEach {println(it)})
}