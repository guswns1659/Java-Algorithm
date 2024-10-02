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

