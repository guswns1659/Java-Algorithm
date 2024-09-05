package leetcode


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
