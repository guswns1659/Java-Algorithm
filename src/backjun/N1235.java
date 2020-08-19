package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rowAndColumn = br.readLine().split(" ");
        int N = Integer.parseInt(rowAndColumn[0]);
        int M = Integer.parseInt(rowAndColumn[1]);
        String[][] castle = new String[N][M];

        for (int row = 0; row < N; row++) {
            String status = br.readLine();
            for (int column = 0; column < M; column++) {
                castle[row][column] = String.valueOf(status.charAt(column));
            }
        }
        System.out.println(test(castle));

    }

    public static int test(String[][] castle) {
        int rowCheck = 0;
        int columnCheck = 0;
        int N = castle.length;
        int M = castle[0].length;

        // 모든 행 검사
        for (int row = 0; row < N; row++) {
            boolean flag = false;
            for (int column = 0; column < M; column++) {
                if (flag) {
                    break;
                }
                if (castle[row][column].equals("X")) {
                    flag = true;
                    rowCheck++;
                }
            }
        }

        // 모든 열 검사
        for (int column = 0; column < M; column++) {
            boolean flag = false;
            for (int row = 0; row < N; row++) {
                if (flag) {
                    break;
                }
                if (castle[row][column].equals("X")) {
                    flag = true;
                    columnCheck++;
                }
            }
        }

        return Math.max((N - rowCheck),(M - columnCheck));
    }
}
