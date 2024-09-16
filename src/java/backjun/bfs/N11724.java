package backjun.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class N11724 {

    private static Map<Integer, Integer> parent = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        Set<Integer> networks = new HashSet<>();

        // parent 초기화
        for (int index = 1; index < N + 1; index++) {
            parent.put(index, index);
        }
        // union
        for (int loop = 0; loop < M; loop++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            union(x,y);
        }

        // find() 재정비
        for (int index = 1; index < N + 1; index++) {
            find(index);
        }

        // set에 옮기고 size 출력
        for (int value : parent.values()) {
            networks.add(value);
        }
        System.out.println(networks.size());
    }

    private static void union(int x, int y) {
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

    private static int find(int x) {
        if (x == parent.get(x)) {
            return x;
        }
        int p = find(parent.get(x));
        parent.put(x, p);
        return p;
    }
}
