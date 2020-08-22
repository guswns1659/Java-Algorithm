package backjun.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numberAndGoal = br.readLine().split(" ");
        int goal = Integer.parseInt(numberAndGoal[1]);

        String[] treeInput = br.readLine().split(" ");

        List<Integer> trees = new ArrayList<>();
        for (String tree : treeInput) {
            trees.add(Integer.parseInt(tree));
        }
        System.out.println(test(trees, goal));
    }

    public static int test(List<Integer> trees, int goal) {
        Collections.sort(trees);
        int min = 0;
        int max = trees.get(trees.size() - 1);

        while (min <= max) {
            int mid = (min + max) / 2;
            long sum = 0;

            for (Integer tree : trees) {
                if ((tree - mid) > 0) {
                    sum += tree - mid;
                }
            }

            if (sum >= goal) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return max;
    }
}
