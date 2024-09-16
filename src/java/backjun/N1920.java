package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] compares = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        test(n, numbers, m, compares).forEach(System.out::println);
    }

    public static List<Integer> test(int n, int[] numbers, int m, int[] compares) {
        Map<Integer, Integer> hashMap = new HashMap<>(n);
        for (int number : numbers) {
            hashMap.put(number, 1);
        }

        List<Integer> answers = new ArrayList<>(m);
        for (int compare : compares) {
            if(hashMap.containsKey(compare)) {
                answers.add(1);
            } else {
                answers.add(0);
            }
        }
        return answers;
    }
}
