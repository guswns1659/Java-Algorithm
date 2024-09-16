package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int[] inputs = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        System.out.println(test(inputs));
    }

    public static String test(int[] inputs) {
        boolean ascending = true;
        boolean descending = true;

        for (int index = 1; index < inputs.length; index++) {
            if (inputs[index] > inputs[index - 1]) {
                descending = false;
            } else {
                ascending = false;
            }
        }

        if (ascending) {
            return "ascending";
        } if (descending) {
            return "descending";
        } else {
            return "mixed";
        }
    }
}
