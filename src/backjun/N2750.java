package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] numbers = new int[testCase];
        for (int index = 0; index < testCase; index++) {
            numbers[index] = Integer.parseInt(br.readLine());
        }
        Arrays.stream(test(numbers)).forEach(System.out::println);
    }
    public static int[] test(int[] numbers) {
        Arrays.sort(numbers);
        return numbers;
    }
}
