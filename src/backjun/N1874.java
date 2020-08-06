package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sequences = new int[N];
        for (int index = 0; index < N; index++) {
            sequences[index] = Integer.parseInt(br.readLine());
        }
        List<String> results = test(N, sequences);
        if (results.isEmpty()) {
            System.out.println("NO");
        } else {
            results.forEach(System.out::println);
        }
    }

    public static List<String> test(int N, int[] sequences) {
        int sequenceIndex = 0;
        int numberIndex = 0;
        int[] numbers = new int[N];
        for (int index = 1; index <= N; index++) {
            numbers[index - 1] = index;
        }
        List<String> answers = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        final String NO = "NO";
        final String PLUS = "+";
        final String MINUS = "-";

        while (sequenceIndex < N) {
            int sequence = sequences[sequenceIndex];
            if (!(1 <= sequence && sequence <= N)) {
                return new ArrayList<>();
            }
            if (stack.isEmpty()) {
                if (numberIndex > N) {
                    return new ArrayList<>();
                }
                stack.push(numbers[numberIndex]);
                answers.add(PLUS);
                numberIndex++;
            } else {
                if (stack.peek() > sequences[sequenceIndex]) {
                    return new ArrayList<>();
                }
                if (stack.peek() < sequences[sequenceIndex]) {
                    stack.push(numbers[numberIndex]);
                    answers.add(PLUS);
                    numberIndex++;
                } else {
                    stack.pop();
                    answers.add(MINUS);
                    sequenceIndex++;
                }
            }
        }
        return answers;
    }
}
