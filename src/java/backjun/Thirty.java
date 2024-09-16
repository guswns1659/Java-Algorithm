package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// split("") 하면 한 단어씩 끊어진다.
// 기본형 배열 sort : Arrays.sort(), 역순 : Arrays.sort(list, Collections.reverseOrder()); 다만, 역순은 기본형 배열은 안된다.

public class Thirty {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] digits = br.readLine().split("");

        boolean zeroIsNotExists = true;

        for (String each : digits) {
            if (each.equals("0")) {
                zeroIsNotExists = false;
                break;
            }
        }
        if (zeroIsNotExists) {
            System.out.println(-1);
        } else {
            int sumOfDigits = 0;
            Arrays.sort(digits, Collections.reverseOrder());
            for (String each : digits) {
                sumOfDigits += Integer.parseInt(each);
            }
            if (!(sumOfDigits % 3 == 0)) {
                System.out.println("-1");
            } else {
                StringBuilder sb = new StringBuilder();
                for (String each : digits) {
                    sb.append(each);
                }
                System.out.println(sb.toString());
            }
        }
    }
}
