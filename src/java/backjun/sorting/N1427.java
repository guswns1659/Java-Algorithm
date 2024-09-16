package backjun.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(test(br.readLine()));
    }

    public static String test(String number) {
        for (int digit = 9; digit > -1; digit--) {
            for (int index = 0; index < number.length(); index++) {
                if (number.charAt(index) - '0' == digit) {
                    System.out.print(digit);
                }
            }
        }
        return "";
    }
}
