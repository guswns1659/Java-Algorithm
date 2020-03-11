package selfPractice;

public class Hanoi {
    public static void main(String[] args) {
        hanoi(4, 1, 3);
    }

    public static void hanoi(int numberOfRing, int x, int y) {
        if (numberOfRing > 1) hanoi(numberOfRing - 1, x, 6 - x - y);
        System.out.printf("원반%d를 기둥 %d에서 기둥 %d로 옮겼습니다.", numberOfRing, x, y);
        System.out.println();
        if (numberOfRing > 1) hanoi(numberOfRing - 1, 6 - x - y, y);
    }
}
