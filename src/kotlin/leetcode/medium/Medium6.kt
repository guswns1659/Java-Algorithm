/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class Solution0 {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        return findLca(root, p, q)
    }

    private fun findLca(cur: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (cur == null || p == null || q == null) {
            return null
        }

        if (cur.`val` == p.`val` || cur.`val` == q.`val`) {
            return cur
        }

        val node1 = findLca(cur.left, p, q)
        val node2 = findLca(cur.right, p, q)

        if (node1 != null && node2 != null) {
            return cur
        }
        if (node1 == null) {
            return node2
        }
        return node1
    }
}

// https://leetcode.com/problems/fraction-to-recurring-decimal/?envType=problem-list-v2&envId=xixy4dq7
class Solution1 {
    // numerator = 분자, denominator = 분모, fraction = 분수
    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        if (numerator == 0) return "0"

        val result = StringBuilder()

        // Determine the sign of the result
        // xor = 다르면 true라서 둘 다 음수일 경우에는 false로 체크해야한다.
        if ((numerator <0 ) xor (denominator <0)) result.append("-")

        // Convert to long to handle overflow
        val num = Math.abs(numerator.toLong())
        val den = Math.abs(denominator.toLong())

        // Append the integer part
        result.append(num / den)

        var remainder = num % den
        if (remainder == 0L) return result.toString()

        // Start processing the fractional part
        result.append(".")
        // 나머지가 반복되는지 처음 등장한 위치를 저장하는 map
        val map = HashMap<Long, Int>()

        // NOTE : 우리가 나눗셈을 하는 과정을 코드로 푼 것
        while (remainder != 0L) {
            if (map.containsKey(remainder)) {
                result.insert(map[remainder]!!, "(")
                result.append(")")
                break
            }

            // 현재 나머지는 반복되지 않았으니 현재 위치를 저장한다.
            map[remainder] = result.length

            remainder *= 10
            result.append(remainder / den)
            remainder %= den
        }
        return result.toString()
    }
}