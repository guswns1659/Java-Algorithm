package backjun.search;

import java.util.*;
import java.io.*;

public class N2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityCount = Integer.parseInt(br.readLine());
        List<Integer> budgets = new ArrayList<>();
        String[] budgetString = br.readLine().split(" ");

        for (int index = 0; index < cityCount; index++) {
            budgets.add(Integer.parseInt(budgetString[index]));
        }

        int budgetLimit = Integer.parseInt(br.readLine());
        Collections.sort(budgets);

        long max = budgets.get(budgets.size() - 1);
        long min = 1;

        while (max >= min) {
            long mid = (max + min) / 2;
            int sum = 0;
            for (int budget : budgets) {
                sum += (mid >= budget) ? budget : mid;
            }

            if (sum > budgetLimit) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(max);
    }
}