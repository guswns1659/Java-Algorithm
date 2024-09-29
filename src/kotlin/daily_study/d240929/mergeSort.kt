package daily_study.d240929

fun mergeSort(arr: IntArray): IntArray {
    if (arr.size == 1) return arr

    val mid = arr.size / 2
    val left = arr.sliceArray(0 until mid)
    val right = arr.sliceArray(mid until arr.size)

    return merge(mergeSort(left), mergeSort(right))
}

private fun merge(left: IntArray, right: IntArray): IntArray {
    val result = IntArray(left.size + right.size)
    var l = 0
    var r = 0

    for (k in result.indices) { // TODO : for문으로 result 인덱스를 돌면서 처리해야함
        when {
            l >= left.size -> result[k] = right[r++]
            r >= right.size -> result[k] = left[l++]
            left[l] > right[r] -> result[k] = right[r++]
            else -> result[k] = left[l++]
        }
    }

    return result
}