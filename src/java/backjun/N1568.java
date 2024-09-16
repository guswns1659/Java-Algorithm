package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(test(Integer.parseInt(br.readLine())));
    }

    public static int test(int number) {
        int count = 1;
        int second = 0;

        while (number > 0) {
            if (count > number) {
                count = 1;
                continue;
            }
            second++;
            number -= count;
            count++;
        }
        return second;
    }
}
