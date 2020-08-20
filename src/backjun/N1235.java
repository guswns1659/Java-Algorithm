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
        int N = castle.length;
        int M = castle[0].length;

        int[] rowStatus = new int[N];
        int[] columnStatus = new int[M];

        // X가 있다면 그 행과 열은 모두 존재하는 것.
        for (int row = 0; row < N; row++) {
            for (int column = 0; column < M; column++) {
                if (castle[row][column].equals("X")) {
                    rowStatus[row] = 1;
                    columnStatus[column] = 1;
                }
            }
        }

        int rowCheck = 0;
        for (int exist : rowStatus) {
            if (exist == 0) {
                rowCheck++;
            }
        }

        int columnCheck = 0;
        for (int exist : columnStatus) {
            if (exist == 0) {
                columnCheck++;
            }
        }

        return Math.max(rowCheck, columnCheck);
    }
}
