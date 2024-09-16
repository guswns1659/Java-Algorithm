package doit.chap5.Practice7;

public class QueenB {
    static int[] position = new int[8];

    public static void main(String[] args) {
        set(0);
    }

    private static void set(int column) {
        for (int row = 0; row < 8; row++) {
            position[column] = row;
            if (column == 7) print();
            else set(column + 1);
        }
    }

    private static void print() {
        for (int row = 0; row < 8; row++) {
            System.out.printf("%2d", position[row]);
        }
        System.out.println();
    }

}
