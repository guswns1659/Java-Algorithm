import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (int loop = 0; loop < testCase; loop++) {
            char[] passwords = br.readLine().toCharArray();
            for (char password : passwords) {
                if (password == '<') {
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                } else if (password == '>') {
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                } else if (password == '-') {
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                } else {
                    leftStack.push(password);
                }
            }
            while (!rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            }
            StringBuilder answer = new StringBuilder();
            while (!leftStack.isEmpty()) {
                answer.append(leftStack.pop());
            }
            System.out.println(answer.reverse().toString());
        }
    }
}