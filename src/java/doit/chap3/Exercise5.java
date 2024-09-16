package doit.chap3;

public class Exercise5 {
    public static void main(String[] args) {
    }

    protected int binSearchX(int[] ints, int length, int key) {
        int index = binarySearch(ints, ints.length, key);
        int result = index;
        for (int pointer = index - 1; pointer > -1; pointer--) {
            if (ints[pointer] == key) result = pointer;
        }
        return result;
    }

    protected int binarySearch(int[] ints, int length, int key) {
        int left = 0;
        int right = length - 1;

        do {
            int middle = (left + right) / 2;
            if (ints[middle] == key) return middle;
            else if (ints[middle] > key) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        } while (left <= right);

        return -1;
    }
}
