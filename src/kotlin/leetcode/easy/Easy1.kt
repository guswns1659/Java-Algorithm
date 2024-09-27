package leetcode.easy


fun main() {
    print(isValid(s = "[]"))
}

// https://leetcode.com/problems/valid-parentheses/description/
fun isValid(s: String): Boolean {
    // ArrayDeque to act as a stack
    val stack = ArrayDeque<Char>()

    // HashMap to map closing brackets to corresponding opening brackets
    val bracketMap = mapOf(')' to '(', '}' to '{', ']' to '[')

    for (char in s) {
        if (char in bracketMap.values) {
            // If it's an opening bracket, push it onto the stack
            stack.addLast(char)
        } else if (char in bracketMap.keys) {
            // If it's a closing bracket, check if it matches the top of the stack
            if (stack.isEmpty() || stack.removeLast() != bracketMap[char]) {
                return false
            }
        } else {
            // If there is an invalid character
            return false
        }
    }

    // In the end, stack should be empty if all brackets are valid
    return stack.isEmpty()
}

// https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
fun peakIndexInMountainArray(arr: IntArray): Int {
    var left = 0
    var right = arr.size - 1

    while (left <= right) { // <=로 바꾼 경우
        val mid = left + (right - left) / 2

        if (arr[mid] < arr[mid + 1]) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return left
}

// https://leetcode.com/problems/sum-of-two-integers/

fun getSum(a: Int, b: Int): Int {
    var aBin = a
    var bBin = b

    while (bBin != 0) {
        val sumWithoutCarry = aBin xor bBin
        val carry = (aBin and bBin) shl 1

        aBin = sumWithoutCarry
        bBin = carry
    }

    return aBin
}

// https://leetcode.com/problems/merge-sorted-array/

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var i = m - 1  // nums1에서 실제 값의 마지막 인덱스
    var j = n - 1  // nums2의 마지막 인덱스
    var k = m + n - 1  // nums1의 총 크기에서 마지막 인덱스

    // nums1과 nums2를 뒤에서부터 비교하여 큰 값을 nums1에 삽입
    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[k--] = nums1[i--]
        } else {
            nums1[k--] = nums2[j--]
        }
    }

    // nums2에 남은 값이 있을 경우 남은 요소를 nums1에 복사
    while (j >= 0) {
        nums1[k--] = nums2[j--]
    }
}

// https://leetcode.com/problems/valid-anagram/
// 내 풀이
fun isAnagram(s: String, t: String): Boolean {
    val words = IntArray(26)
    for (c in s) {
        words[c - 'a'] += 1
    }

    val words2 = IntArray(26)
    for (c2 in t) {
        words2[c2 - 'a'] += 1
    }

    return words.contentEquals(words2)
}

// gpt
fun isAnagram2(s: String, t: String): Boolean {
    if (s.length != t.length) return false // 길이가 다르면 바로 false

    val count = IntArray(26) // 알파벳 a-z까지의 빈도를 저장하는 배열

    for (i in s.indices) {
        count[s[i] - 'a']++  // 첫 번째 문자열의 문자는 +1
        count[t[i] - 'a']--  // 두 번째 문자열의 문자는 -1
    }

    // count 배열에 0이 아닌 값이 있으면 anagram이 아님
    return count.all { it == 0 }
}

// https://leetcode.com/problems/happy-number/
fun isHappy(n: Int): Boolean {
    // 이미 방문한 숫자들을 기록할 해시셋
    val seen = mutableSetOf<Int>()
    var number = n

    // 숫자가 1에 도달할 때까지 반복
    while (number != 1) {
        // 현재 숫자가 이미 방문한 숫자들 중 하나라면 사이클 발생
        if (number in seen) return false

        // 현재 숫자를 해시셋에 추가
        seen.add(number)

        // 현재 숫자의 제곱합을 계산하여 number를 업데이트
        number = getSumOfSquares(number)
    }

    // 숫자가 1에 도달하면 행복한 수임
    return true
}

fun getSumOfSquares(num: Int): Int {
    var sum = 0
    var number = num

    // 각 자리 숫자의 제곱의 합을 계산
    while (number > 0) {
        // 가장 오른쪽 자리 숫자를 추출
        val digit = number % 10

        // 숫자의 제곱을 합계에 추가
        sum += digit * digit

        // 자리 숫자 제거
        number /= 10
    }

    // 제곱의 합을 반환
    return sum
}

