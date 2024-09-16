package doit.chap4.Practice4C;

import java.util.Scanner;

public class ringBuffer {
    public static void main(String[] args) {
        ringBufferTest();
    }

    private static void ringBufferTest() {
        Scanner scanner = new Scanner(System.in);
        final int N = 10;
        int[] ints = new int[N];
        int count = 0;
        int retry;

        System.out.println("정수를 입력하세요");

        do {
            System.out.printf("%d번째 정수 : ", count + 1);
            ints[count++ % N] = scanner.nextInt();

            System.out.print("계속 할까요? (예.1/ 아니오.0) : ");
            retry = scanner.nextInt();
        } while (retry == 1);

        int i = count - N;
        if (i < 0) i = 0;
        for (; i < count; i++)
            System.out.printf("%2d번째의 정수 = %d\n", i + 1, ints[i % N]);
    }
}
