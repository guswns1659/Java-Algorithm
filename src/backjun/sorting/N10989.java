package backjun.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] array = new int[10001];
        for (int loop = 0; loop < testCase; loop++) {
            array[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder result = new StringBuilder();

        for (int index = 0; index < 10001; index++) {
            if (array[index] != 0) {
                for (int loop = 0; loop < array[index]; loop++) {
                    result.append(index).append("\n");
                }
            }
        }
        System.out.print(result);
    }
}
