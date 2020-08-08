import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int count = 1;
        Stack<Integer> stack = new Stack<>();
        List<String> answers = new ArrayList<>();
        boolean ok = true;

        for (int loop = 0; loop < number; loop++) {
            int current = Integer.parseInt(br.readLine());
            while (count <= current) {
                stack.push(count++);
                answers.add("+");
            }
            if (stack.peek() == current) {
                stack.pop();
                answers.add("-");
            } else {
                ok = false;
                break;
            }
        }

        if (!ok) {
            System.out.println("NO");
        } else {
            answers.forEach(System.out::println);
        }
    }
}