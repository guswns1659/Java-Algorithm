package doit.chap3;

public class Practice1 {
    public static void main(String[] args) {
        int[] ints = {22,8,55,32,120,55,70};
        int index = sequentialSearch(ints, ints.length, 100);
        System.out.println(index);
    }

    private static int sequentialSearch(int[] ints, int length, int key) {
        int count = 0;
        while (count < length) {
            if (ints[count] == key) return count;
            count++;
        }
        return -1;
    }
}
