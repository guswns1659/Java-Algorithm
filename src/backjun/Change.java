package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Change {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = 1000 - (Integer.parseInt(br.readLine()));
        int[] coins = {500, 100, 50, 10, 5, 1};

        int answer = 0;
        int remainder = change;
        for (int coin : coins) {
            int quotient = remainder / coin;
            remainder = remainder % coin;
            if (quotient < 1) continue;
            else answer += quotient;
            if (remainder == 0) System.out.println(answer);
        }
    }
}
