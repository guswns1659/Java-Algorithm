package backjun.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int loop = 0; loop < testCase; loop++) {
            int number = Integer.parseInt(br.readLine());
            if (number != 0) {
                stack.push(number);
            } else {
                stack.pop();
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        System.out.println(result);
    }
}
