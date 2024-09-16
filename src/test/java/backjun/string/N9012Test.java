package backjun.string;

import java.util.*;
import java.io.*;

public class N9012Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for (int loop = 0; loop < testCase; loop++) {
            char[] chars = br.readLine().toCharArray();
            stack.clear();

            boolean flag = true;

            for (char character : chars) {
                if (character == '(') {
                    stack.push(character);
                } else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (flag) {
                if (!stack.isEmpty()) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            } else {
                System.out.println("NO");
            }
        }
    }
}