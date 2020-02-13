package doit.chap4.Practice2;

import doit.chap4.Practice1.IntStack;

import java.util.Scanner;

public class IntStackTester {
    public static void main(String[] args) {
        intStacktest();
    }

    private static void intStacktest() {
        Scanner scanner = new Scanner(System.in);
        IntStack intStack = new IntStack(64);

        while (true) {
            System.out.println("현재 데이터 수 : "+ intStack.size() + " / " +
                    intStack.capacity());
            System.out.print(" 1. 푸시 2. 팝 3. 피크 4. 덤프 0. 종료 : ");

            int menu = scanner.nextInt();
            if (menu == 0) break;

            int value;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    value = scanner.nextInt();
                    try {
                        intStack.push(value);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println(" 스택이 가득 찼습니다. ");
                    }
                    break;
            }


        }


    }
}
