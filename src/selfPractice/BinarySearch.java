package selfPractice;

public class BinarySearch {
    public static void main(String[] args) {
        int[] ints = {1,3,5,6,8,9};
        System.out.println(binarySearch(ints, 8));
        System.out.println(binarySearch(ints, 3));
        System.out.println(binarySearch(ints, 6));
    }

    private static int binarySearch(int[] ints, int key) {
        int left = 0;
        int right = ints.length - 1;
        do {
            int middle = (left + right) / 2;
            if (ints[middle] == key) return middle;
            else if (ints[middle] > key) right = middle - 1;
            else left = middle + 1;
        } while(left <= right);
        return -1;
    }

}
