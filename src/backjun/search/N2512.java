package backjun.search;

import java.io.*;
import java.util.*;

public class N2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int regionCount = Integer.parseInt(br.readLine());
        List<Integer> budgets = new ArrayList<>(regionCount);

        String[] budgetString = br.readLine().split(" ");
        for (String budget : budgetString) {
            budgets.add(Integer.parseInt(budget));
        }
        int totalBudget = Integer.parseInt(br.readLine());
        System.out.println(test(budgets, totalBudget));

    }

    public static long test(List<Integer> budgets, int totalBudgets) {
        Collections.sort(budgets);

        long max = budgets.get(budgets.size() - 1);
        long min = 1;

        while (min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;

            for (int budget : budgets) {
                long gap = budget - mid;
                if (gap >= 0) {
                    sum += mid;
                } else {
                    sum += budget;
                }
            }

            if (sum < totalBudgets) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return max;
    }
}
