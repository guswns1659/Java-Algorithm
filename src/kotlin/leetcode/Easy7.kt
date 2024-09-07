package leetcode

// https://leetcode.com/problems/isomorphic-strings/
class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val mapA = LinkedHashMap<Char, Int>()
        val mapB = LinkedHashMap<Char, Int>()

        // s 문자열의 각 문자의 빈도를 LinkedHashMap에 저장
        for (c in s) {
            mapA[c] = mapA.getOrDefault(c, 0) + 1
        }

        // t 문자열의 각 문자의 빈도를 LinkedHashMap에 저장
        for (c2 in t) {
            mapB[c2] = mapB.getOrDefault(c2, 0) + 1
        }

        // LinkedHashMap의 values()를 리스트로 변환하여 비교
        return mapA.values.toList() == mapB.values.toList()
    }
}


// https://leetcode.com/problems/non-decreasing-array/
class Solution2 {
    fun checkPossibility(nums: IntArray): Boolean {
        var count = 0

        for (i in nums.indices) {
            if (count > 1) return false
            if (i < nums.size - 1 && nums[i] > nums[i+1]) { // outOfBound가 발생할 수 있음.
                count++
            }
        }

        return count == 1
    }
}
