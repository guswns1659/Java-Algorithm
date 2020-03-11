package selfPractice;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] ints = {5,4,3,2,1};
        quickSort(ints, 0, ints.length - 1);
        print(ints);
    }

    public static void print(int[] ints) {
        Arrays.stream(ints).forEach(System.out::println);
    }

    public static void quickSort(int[] ints, int left, int right) {
        int pl = left;
        int pr = right;
        int pivot = ints[(pl + pr) / 2];

        do {
            while(ints[pl] < pivot) pl++;
            while(pivot < ints[pr]) pr--;
            if (pl <= pr) swap(ints, pl++, pr--);
        } while(pl <= pr);

        if (left < pr) quickSort(ints, left, pr);
        if (pl < right) quickSort(ints, pl, right);
    }

    public static void swap(int[] ints, int index1, int index2) {
        int temp = ints[index1];
        ints[index1] = ints[index2];
        ints[index2] = temp;
    }
}
