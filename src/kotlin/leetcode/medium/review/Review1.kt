package leetcode.medium.review

// https://leetcode.com/problems/number-of-islands/submissions/1409388771/
class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0 // omit

        val row = grid.size
        val column = grid[0].size
        var count = 0

        fun dfs(r: Int, c: Int) {
            if (r < 0 || c < 0 || r >= row || c >= column || grid[r][c]=='0') { // 벗어나는 경우를 빼먹음
                return
            }
            grid[r][c] = '0';
            dfs(r+1, c)
            dfs(r-1, c)
            dfs(r, c+1)
            dfs(r, c-1)
        }

        for (r in grid.indices) {
            for (c in grid[r].indices) {
                if (grid[r][c] == '1') {
                    count++
                    dfs(r, c)
                }
            }
        }

        return count
    }
}

// https://leetcode.com/problems/longest-increasing-subsequence/description/
fun lis(nums: IntArray): Int {
    val dp = IntArray(nums.size) { 1 }

    for (i in 1 until nums.size) {
        for (j in 0 until i) {
            if (nums[i] > nums[j]) {
                dp[i] = maxOf(dp[i], dp[j]+1)
            }
        }
    }
    return dp.maxOrNull() ?: 1
}

// https://leetcode.com/problems/generate-parentheses/
fun generateParenthesis(n: Int): List<String> {
    val list = mutableListOf<String>()
    b(n, 0, 0, "", list)
    return list.toList()
}

fun b(n: Int, o: Int, c: Int, cur: String, list: MutableList<String>) {
    if (cur.length == n * 2) {
        list.add(cur)
        return
    }

    if (o < n) {
        b(n, o+1, c, cur + "(", list)
    }
    if (c < o) {
        b(n, o, c+1, cur + ")", list)
    }
}


fun main() {
    print(generateParenthesis(3))
}

