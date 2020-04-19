package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LostBracket {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split("-");

        int miniumResult = 0;

        for (int count = 0; count < tokens.length; count++) {
            int number = calculate(tokens[count]);

            if (count == 0) number *= -1;
            miniumResult -= number;
        }

        System.out.println(miniumResult);
    }

    private static int calculate(String token) {
        String[] tokens = token.split("\\+");
        int result = 0;
        for (String each : tokens) {
            result += Integer.parseInt(each);
        }
        return result;
    }
}
