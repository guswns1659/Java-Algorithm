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
        List<String> results = test(N, br);
        if (results.isEmpty()) {
            System.out.println("NO");
        } else {
            results.forEach(System.out::println);
        }
    }

    public static List<String> test(int N, BufferedReader br) throws IOException {
        int count = 1;
        Stack<Integer> numbers = new Stack<>();
        List<String> results = new ArrayList<>();

        for (int loop = 0; loop < N; loop++) {
            int data = Integer.parseInt(br.readLine());
            while (count <= data) {
                numbers.push(count);
                count++;
                results.add("+");
            }
            if (numbers.get(numbers.size() - 1) == data) {
                numbers.pop();
                results.add("-");
            } else {
                return new ArrayList<>();
            }
        }
        return results;
    }
}
