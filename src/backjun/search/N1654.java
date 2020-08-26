package backjun.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] hadAndNeed = br.readLine().split(" ");
        int need = Integer.parseInt(hadAndNeed[1]);
        int had = Integer.parseInt(hadAndNeed[0]);

        List<Integer> cables = new ArrayList<>(had);
        for (int loop = 0; loop < had; loop++) {
            cables.add(Integer.parseInt(br.readLine()));
        }

        System.out.println(test(cables, need));
    }

    public static long test(List<Integer> cables, int need) {
        Collections.sort(cables);

        long max = cables.get(cables.size() - 1);
        long min = 1;
        long maxLength = 0;

        while (min <= max) {
            long mid = (min + max) / 2;
            int sum = 0;

            for (int cable : cables) {
                sum += cable / mid;
            }

            if (sum < need) {
                max = mid - 1;
            } else {
                maxLength = Math.max(maxLength, mid);
                min = mid + 1;
            }
        }
        return max;
    }
}
