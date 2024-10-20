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

fun main() {
    print(permute(intArrayOf(1,2,3)))
}