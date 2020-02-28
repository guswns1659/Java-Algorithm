package doit.chap5.chap6.Practice9;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] ints = {5,8,4,2,6,1,3,9,7};
        quickSort(ints, 0, ints.length - 1);
        print(ints);
    }

    private static void print(int[] ints) {
        Arrays.stream(ints).forEach(System.out::println);
    }

    private static void quickSort(int[] ints, int left, int right) {
        int pl = left;
        int pr = right;
        int pivot = ints[(pl+pr) / 2];

        do {
            while (ints[pl] < pivot) pl++;
            while (ints[pr] > pivot) pr--;
            if (pl <= pr) swap(ints, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSort(ints, left, pr);
        if (pl < right) quickSort(ints, pl, right);
    }

    private static void swap(int[] ints, int i, int i1) {
        int temp = ints[i];
        ints[i] = ints[i1];
        ints[i1] = temp;
    }
}
