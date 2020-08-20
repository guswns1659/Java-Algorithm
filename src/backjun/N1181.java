package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        Set<String> wordSet = new HashSet<>();
        for (int loop = 0; loop < testCase; loop++) {
            wordSet.add(br.readLine());
        }
        List<String> words = new ArrayList<>(wordSet);
        test(words).forEach(System.out::println);
    }

    public static List<String> test(List<String> words) {
        words.sort((w1, w2) -> {
            if (w1.length() == w2.length()) {
                return w1.compareTo(w2);
            }
            return Integer.compare(w1.length(), w2.length());
        });
        return words;
    }
}
