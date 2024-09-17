package leetcode


fun main() {
    print(isValid(s = "[]"))
}

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
fun findDisappearedNumbers(nums: IntArray): List<Int> {
    // 숫자의 존재를 표시하기 위해 nums 배열 자체를 사용
    for (i in nums.indices) {
        val index = kotlin.math.abs(nums[i]) - 1
        if (nums[index] > 0) {
            nums[index] = -nums[index] // 해당 인덱스에 있는 숫자를 음수로 변환
        }
    }

    val result = mutableListOf<Int>()
    // 음수로 변환되지 않은 인덱스는 해당 숫자가 없다는 것을 의미
    for (i in nums.indices) {
        if (nums[i] > 0) {
            result.add(i + 1)
        }
    }

    return result
}
