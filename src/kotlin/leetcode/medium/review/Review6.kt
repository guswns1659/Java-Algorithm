package leetcode.medium.review


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


fun main() {
    print(canFinish(2, arrayOf(intArrayOf(1,0), intArrayOf(0,1))))
    print(canFinish(2, arrayOf(intArrayOf(1,0))))
}