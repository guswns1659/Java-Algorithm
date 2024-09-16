package backjun.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NX = br.readLine().split(" ");
        int X = Integer.parseInt(NX[1]);
        String[] nums = br.readLine().split(" ");
        StringBuilder answer = new StringBuilder();

        for (String num : nums) {
            if (Integer.parseInt(num) < X) {
                answer.append(num + " ");
            }
        }
        System.out.println(answer.toString());
    }
}
