package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N5397 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int test = 0; test < testCase; test++) {
            System.out.println(test(br.readLine()));
        }
    }

    public static String test(String input) {
        char[] inputs = input.toCharArray();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (char character : inputs) {
            if (character == '-') {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                }
            } else if (character == '>') {
                if (!rightStack.isEmpty()) {
                    leftStack.push(rightStack.pop());
                }
            } else if (character == '<') {
                if (!leftStack.isEmpty()) {
                    rightStack.push(leftStack.pop());
                }
            } else {
                leftStack.push(character);
            }
        }
        while (!rightStack.isEmpty()) {
            leftStack.add(rightStack.pop());
        }
        StringBuilder answer =new StringBuilder();
        while (!leftStack.isEmpty()) {
            answer.append(leftStack.pop());
        }
        return answer.reverse().toString();
    }
}
