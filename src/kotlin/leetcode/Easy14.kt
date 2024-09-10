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
