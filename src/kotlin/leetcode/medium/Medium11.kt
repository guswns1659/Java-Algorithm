package leetcode.medium

// https://leetcode.com/problems/binary-tree-inorder-traversal/
fun inorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val stack = mutableListOf<TreeNode>()
    var current: TreeNode? = root

    while (current != null || stack.isNotEmpty()) {
        // 왼쪽 노드로 계속 이동
        while (current != null) {
            stack.add(current)  // 스택에 노드를 추가
            current = current.left
        }
        // 스택에서 노드를 꺼내서 처리
        current = stack.removeAt(stack.size - 1)  // 스택에서 마지막 요소 제거
        result.add(current.`val`)
        // 오른쪽 노드로 이동
        current = current.right
    }

    return result
}

// https://leetcode.com/problems/group-anagrams/description/
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = mutableMapOf<List<Int>, MutableList<String>>()

    for (str in strs) {
        val arr = IntArray(26)
        for (c in str) {
            arr[c - 'a']++
        }

        val list = map.getOrDefault(arr.toList(), mutableListOf())
        list.add(str)
        map[arr.toList()] = list
    }

    return map.values.toList()
}

fun main() {
    print(groupAnagrams(arrayOf("ddddddddddg","dgggggggggg")))
}

// https://leetcode.com/problems/largest-number/
fun largestNumber(nums: IntArray): String {
    val stringList = nums.map { it.toString() }.toList()

    val result = stringList.sortedWith { a, b -> (b + a).compareTo(a + b) }.joinToString("")

    return if (result[0] == '0') "0" else result
}
