package doit.chap5.Practice3;

import doit.chap4.Practice1.IntStack;

import java.util.Scanner;

public class Recur {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수를 입력하세요");
        recur(scanner.nextInt());
    }

    private static void recur(int number) {
        IntStack stack = new IntStack(number);

        while (true) {
            if (number > 0) {
                stack.push(number);
                number = number - 1;
                continue;
            }
            if (!stack.isEmpty()) {
                number = stack.pop();
                System.out.println(number);
                number = number - 2;
                continue;
            }
            break;
        }
    }
}
