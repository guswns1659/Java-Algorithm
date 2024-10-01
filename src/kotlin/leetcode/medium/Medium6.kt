// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=problem-list-v2&envId=xixy4dq7
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

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=problem-list-v2&envId=xixy4dq7
class Solution3 {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        // 숫자에 매핑된 문자들
        val digitToChar = mapOf(
            '2' to "abc", '3' to "def", '4' to "ghi",
            '5' to "jkl", '6' to "mno", '7' to "pqrs",
            '8' to "tuv", '9' to "wxyz"
        )

        val result = mutableListOf<String>()

        // 재귀 함수
        fun backtrack(combination: StringBuilder, nextIndex: Int) {
            // 모두 탐색해서 조합을 완료했을 때
            if (nextIndex == digits.length) {
                result.add(combination.toString())
                return
            }

            // 다음 숫자에 매핑된 문자들 가져오기
            val letters = digitToChar[digits[nextIndex]]!!
            for (letter in letters) {
                // 문자 추가하고 재귀 호출
                combination.append(letter)
                backtrack(combination, nextIndex + 1)
                // 다시 돌아와서 문자 제거
                combination.deleteCharAt(combination.length - 1)
            }
        }

        backtrack(StringBuilder(), 0) // 초기 값으로 빈 문자열과 첫 번째 인덱스
        return result
    }
}

// https://leetcode.com/problems/longest-palindromic-substring/description/
class Solution4 {
    fun longestPalindrome(s: String): String {
        /*
        - setting start, end
        - 각 인덱스를 순회하면서 짝수, 홀수 palindrom을 계산한다.
            - 중심에서 왼쪽, 오른쪽 인덱스를 늘려가며 동일한지 while문으로 확인
        - 만약 계산한 len가 현재 start, end보다 길면 start, end를 해당 문자로 업데이트
        -
         */

        if (s.isEmpty()) return ""
        var start = 0 // 현재 가장 긴 팰린드롬의 시작 인덱스
        var end = 0 // 현재 가장 긴 팰린드롬의 끝 인덱스

        for (i in s.indices) {
            val len1 = expandAroundCenter(s, i, i) // 홀수 길이 팰린드롬 검사
            val len2 = expandAroundCenter(s, i, i+1) // 짝수 길이 팰린드롬 검사
            val len = maxOf(len1, len2)

            // 더 긴 팰린드롬을 찾으면 start와 end 업데이트
            if (len > end - start) {
                start = i - (len - 1) / 2 // 현재 팰런드롬의 중심은 i 이기 때문에 팰런드롬의 start 인덱스를 구하기 위함
                end = i + len / 2
            }
        }
        return s.substring(start, end + 1)

    }

    private fun expandAroundCenter(s: String, start: Int, end: Int): Int {
        var l = start
        var r = end

        // 양쪽으로 확장하며 팰린드롬인지 확인
        while(l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }

        return r - l - 1 // 리턴될 때는 이미 한번 벗어난 상태라 -1을 해준다.
    }
}