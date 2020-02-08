package memory;

import java.util.Scanner;

public class BinarySerach {
    public static void main(String[] args) {
        binarySearchTest();
    }

    private static void binarySearchTest() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("요소수를 입력하세요. : ");
        int length = scanner.nextInt();
        int[] ints = new int[length];

        System.out.println("오름 차순으로 입력하세요!");
        System.out.print("x[0] : ");
        ints[0] = scanner.nextInt();

        for (int index = 1; index < length; index++){
            do {
                System.out.println("ints["+index+"] : " );
                ints[index] = scanner.nextInt();
            } while (ints[index] < ints[index-1]);
        }

        System.out.print("검색할 값 : ");
        int key = scanner.nextInt();

        int index = binarySearch(ints, length, key);
        System.out.println(index);
    }

    private static int binarySearch(int[] ints, int length, int key) {
        int left = 0;
        int right = length - 1;

        do {
            int middle = (left + right) / 2;
            if (ints[middle] == key) return middle;
            else if (ints[middle] > key) {
                right = middle-1;
            }
            else {
                left = middle + 1;
            }
        } while (left > right);

        return -1;
    }
}
