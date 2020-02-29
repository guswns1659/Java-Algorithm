package memory;

import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("하노이 탑의 개수를 입력하세요!");
        hanoiMove(scanner.nextInt(), 1, 3);
    }

    private static void hanoiMove(int numberOfRing, int x, int y) {
        if (numberOfRing > 1) hanoiMove(numberOfRing - 1, x, 6 - x - y);
        System.out.printf("원반%d를 %d기둥에서 %d기둥으로 옮겼습니다.", numberOfRing, x, y);
        System.out.println();
        if (numberOfRing > 1) hanoiMove(numberOfRing - 1, 6 - x - y, y);

    }

}
