package backjun.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int number = 0;
        String answer = "";

        while (N > 0) {
            number++;
            answer = Integer.toString(number);
            if (answer.contains("666")) {
                N--;
            }
        }
        System.out.println(answer);
    }
}
