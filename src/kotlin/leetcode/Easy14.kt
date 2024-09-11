package leetcode

// https://leetcode.com/problems/trim-a-binary-search-tree/
// TBU..

// https://leetcode.com/problems/linked-list-cycle/
class Solution1 {
    fun hasCycle(head: ListNode?): Boolean {
        val visitedNodes = mutableSetOf<ListNode>()

        var current = head
        while (current != null) {
            if (visitedNodes.contains(current)) {
                return true
            }
            visitedNodes.add(current)
            current = current.next
        }

        return false
    }
}

// https://leetcode.com/problems/min-stack/
class MinStack() {
    private val stack1: MutableList<Int> = mutableListOf()
    private val stack2: MutableList<Int> = mutableListOf()

    fun push(`val`: Int) {
        stack1.add(`val`)
        if (stack2.isEmpty()) {
            stack2.add(`val`)
        } else {
            if (stack2[stack2.size - 1] > `val`) {
                stack2.add(`val`)
            }
        }
    }

    fun pop() {
        val data = stack1.removeAt(stack1.size - 1)
        if (data == stack2[stack2.size - 1]) {
            stack2.removeAt(stack2.size -1)
        }
    }

    fun top(): Int {
        return stack1[stack1.size - 1]
    }

    fun getMin(): Int {
        return stack2[stack2.size - 1]
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */



