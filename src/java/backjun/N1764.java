package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nAndM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = nAndM[0];
        int m = nAndM[1];
        List<String> names = new ArrayList<>(n+m);
        for (int loop = 0; loop < n + m; loop++) {
            names.add(br.readLine());
        }
        List<String> answer = test(nAndM, names);
        System.out.println(answer.size());
        answer.forEach(System.out::println);
    }

    public static List<String> test(int[] nAndM, List<String> names) {
        int n = nAndM[0];
        int m = nAndM[1];

        Set<String> answers = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = n; j < n+m; j++) {
                if (names.get(i).equals(names.get(j))) {
                    answers.add(names.get(i));
                }
            }
        }
        List<String> realAnswers = new ArrayList<>(answers);
        Collections.sort(realAnswers);
        return realAnswers;
    }
}
