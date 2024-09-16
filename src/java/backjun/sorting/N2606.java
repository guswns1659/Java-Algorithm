package backjun.sorting;

import java.util.*;
import java.io.*;

public class N2606 {

    private static Map<Integer, Integer> parent = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int comCount = Integer.parseInt(br.readLine());
        int edgeCount = Integer.parseInt(br.readLine());

        for (int computer = 1; computer < comCount + 1; computer++) {
            parent.put(computer, computer);
        }

        for (int loop = 0; loop < edgeCount; loop++) {
            String[] relations = br.readLine().split(" ");
            int x = Integer.parseInt(relations[0]);
            int y = Integer.parseInt(relations[1]);
            union(x,y);
        }

        for (int computer = 1; computer < comCount + 1; computer++) {
            find(computer);
        }

        int target = parent.get(1);
        int sum = 0;

        for (int value : parent.values()) {
            if (value == target) {
                sum++;
            }
        }

        System.out.println(sum - 1);
    }

    public static void union(int x, int y) {
        int x2 = find(x);
        int y2 = find(y);

        if (x2 != y2) {
            if (x < y) {
                parent.put(y2, x2);
            } else {
                parent.put(x2, y2);
            }
        }
    }

    public static int find(int x) {
        if (x == parent.get(x)) {
            return x;
        }
        int p = find(parent.get(x));
        parent.put(x, p);
        return p;
    }
}