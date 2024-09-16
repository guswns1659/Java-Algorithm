package doit.chap5.Practice1;

import java.util.Scanner;

public class Factorial {
    static int factorial(int n) {
        if (n < 1) return 1;
        else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력하세요!");
        int number = scanner.nextInt();

        System.out.printf("%d!의 결과는 : %d입니다.", number, factorial(number));
        System.out.println();
    }
}
