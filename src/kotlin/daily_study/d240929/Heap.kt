package daily_study.d240929

class Heap(private val isMinHeap: Boolean = true) {
    private val list = mutableListOf<Int>()

    // 부모 노드의 인덱스를 계산하는 함수
    private fun parent(index: Int) = (index - 1) / 2

    // 왼쪽 자식 노드의 인덱스를 계산하는 함수
    private fun leftChild(index: Int) = 2 * index + 1

    // 오른쪽 자식 노드의 인덱스를 계산하는 함수
    private fun rightChild(index: Int) = 2 * index + 2

    // 요소를 추가하는 함수
    fun add(value: Int) {
        list.add(value)
        var currentIndex = list.size - 1
        // 상향 이동을 통해 힙 속성 유지
        while (currentIndex > 0 && compare(currentIndex, parent(currentIndex))) {
            swap(currentIndex, parent(currentIndex))
            currentIndex = parent(currentIndex)
        }
    }

    // 최상위 요소를 제거하는 함수
    fun removePeak(): Int {
        if (list.isEmpty()) throw NoSuchElementException("Heap is empty")
        val peak = list[0]
        val lastValue = list.removeAt(list.size - 1)
        if (list.isNotEmpty()) {
            list[0] = lastValue
            heapify(0)  // 루트에서부터 힙 속성을 복원
        }
        return peak
    }

    // 힙을 재정렬하는 함수 (하향 이동)
    private fun heapify(index: Int) {
        val left = leftChild(index)
        val right = rightChild(index)
        var largestOrSmallest = index

        if (left < list.size && compare(left, index)) largestOrSmallest = left
        if (right < list.size && compare(right, largestOrSmallest)) largestOrSmallest = right

        if (largestOrSmallest != index) {
            swap(index, largestOrSmallest)
            heapify(largestOrSmallest)  // 재귀적으로 힙 속성을 유지
        }
    }

    // 비교 함수 (최소 힙 또는 최대 힙에 따라 다름)
    private fun compare(i: Int, j: Int) = if (isMinHeap) list[i] < list[j] else list[i] > list[j]

    // 두 인덱스의 값을 교환하는 함수
    private fun swap(i: Int, j: Int) {
        val temp = list[i]
        list[i] = list[j]
        list[j] = temp
    }

    // 힙의 상태를 출력하는 함수 (디버깅용)
    fun display() {
        println(list)
    }
}

