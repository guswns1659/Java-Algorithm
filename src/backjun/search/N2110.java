package backjun.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N2110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] homeAndRouter = br.readLine().split(" ");
        int home = Integer.parseInt(homeAndRouter[0]);
        int router = Integer.parseInt(homeAndRouter[1]);
        List<Integer> homes = new ArrayList<>();

        for (int location = 0; location < home; location++) {
            homes.add(Integer.parseInt(br.readLine()));
        }
        System.out.println(test(homes, router));
    }

    public static int test(List<Integer> homes, int router) {
        Collections.sort(homes);
        int min = homes.get(1) - homes.get(0);
        int max = homes.get(homes.size()-1) - homes.get(0);

        while (min <= max) {
            int mid = (min + max) / 2;
            int value = homes.get(0);
            int count = 1;
            for (int index = 1; index < homes.size(); index++) {
                if (homes.get(index) >= value + mid) {
                    value = homes.get(index);
                    count += 1;
                }
            }
            if (count >= router) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return max;
    }
}
