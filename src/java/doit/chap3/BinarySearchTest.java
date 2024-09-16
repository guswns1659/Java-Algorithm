package doit.chap3;

import java.util.Arrays;

public class BinarySearchTest {
    public static void main(String[] args) {
        int[] ints = {1, 2, 6, 8};
        int index = Arrays.binarySearch(ints, 10);
        System.out.println(index);
    }
}

