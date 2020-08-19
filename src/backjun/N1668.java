package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class N1668 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        List<Integer> trophies = new ArrayList<>();
        for (int loop = 0; loop < testCase; loop++) {
            trophies.add(Integer.parseInt(br.readLine()));
        }
        test(trophies).forEach(System.out::println);
    }

    public static List<Integer> test(List<Integer> trophies) {
        int leftCount = 1;
        int rightCount = 1;
        int leftCurrent = trophies.get(0);
        int rightCurrent = trophies.get(trophies.size()-1);

        for (int index = 1; index < trophies.size(); index++) {
            if (leftCurrent < trophies.get(index)) {
                leftCount++;
                leftCurrent = trophies.get(index);
            }
        }

        for (int index = trophies.size() - 2; index >= 0; index--) {
            if (rightCurrent < trophies.get(index)) {
                rightCount++;
                rightCurrent = trophies.get(index);
            }
        }
        List<Integer> results = new ArrayList<>();
        results.add(leftCount);
        results.add(rightCount);
        return results;
    }
}
