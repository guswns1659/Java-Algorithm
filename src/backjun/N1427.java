package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(test(br.readLine()));
    }

    public static String test(String number) {
        char[] chars = number.toCharArray();
        List<Integer> charToNumbers = new ArrayList<>();
        for (char character : chars) {
            charToNumbers.add((int) character - 48);
        }

        charToNumbers.sort(Comparator.reverseOrder());
        StringBuilder answer = new StringBuilder();
        charToNumbers.stream().forEach(num -> answer.append(num));
        return answer.toString();
    }
}
