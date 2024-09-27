package leetcode.easy

import java.util.*


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

// https://leetcode.com/problems/kth-largest-element-in-a-stream/
// 힙이나 우선순위 큐 이용하는 알고리즘

class KthLargest(val k: Int, nums: IntArray) {
    private var pq: PriorityQueue<Int> = PriorityQueue()

    init {
        // nums 배열의 요소를 순회하면서 k개의 요소만 유지
        nums.forEach { add(it) }
    }

    fun add(`val`: Int): Int {
        pq.add(`val`)
        if (pq.size > k) {
            pq.poll()
        }
        return pq.peek()
    }
}


