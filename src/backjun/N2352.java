package backjun;

import java.util.Arrays;
import java.util.Scanner;

public class N2352 {
    static int lis(int[] a) {
        int[] tailTable = new int[a.length];

        tailTable[0] = a[0]; // 초기값
        int length = 1;

        for (int i = 1; i < a.length; i++) { //후보값이 처음값보다 작을 때
            if (tailTable[0] > a[i]) {
                tailTable[0] = a[i];
            } else if (tailTable[length - 1] < a[i]) { //후보값이 마지막값보다 클 때
                tailTable[length] = a[i];
                length += 1;
            } else { //그 외의 경우엔 적절한 위치에 교체한다.
                int idx = Arrays.binarySearch(tailTable, 0, length, a[i]);
                idx = (idx < 0) ? -idx - 1 : idx;
                tailTable[idx] = a[i];
            }
        }
        System.out.println(Arrays.toString(tailTable));
        return length;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        System.out.println(lis(a));
    }
}

