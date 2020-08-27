package backjun.string;

import java.util.*;
import java.io.*;

public class N4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            System.out.println(isBalanced(input));
        }
    }

    private static String isBalanced(String input) {
        boolean result = true;

        if (input.equals(".")) {
            result = true;
        }

        Stack<Character> stack = new Stack<>();

        for (char one : input.toCharArray()) {
            if (one == '(' || one == '[') {
                stack.push(one);
            } else if (one == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    result = false;
                    break;
                }
            } else if (one == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    result = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            result = false;
        }

        return result ? "yes" : "no";
    }
}
