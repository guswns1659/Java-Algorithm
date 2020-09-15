package backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int digit = N.length();

        // 탐색을 시작하는 가장 작은 수
        int min = Integer.parseInt(N) - (digit * 9);
        int answer = 0;

        for (int num = min; num < Integer.parseInt(N) + 1; num++) {
            int temp = num;
            int sum = num;
            // 자리수를 더하는 식
            while (temp > 0) {
                sum += (temp % 10);
                temp /= 10;
            }
            if (sum == Integer.parseInt(N)) {
                answer = num;
                break;
            }
        }
        System.out.println(answer);
    }
}
