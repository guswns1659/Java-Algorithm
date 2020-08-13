package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class N4195 {

    public static Map<String, String> parent = new HashMap<>();
    public static Map<String, Integer> networks = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int loop = 0; loop < testCase; loop++) {
            int relationNumber = Integer.parseInt(br.readLine());
            parent = new HashMap<>();
            networks = new HashMap<>();

            for (int relation = 0; relation < relationNumber; relation++) {
                String[] friends = br.readLine().split(" ");
                String friend1 = friends[0];
                String friend2 = friends[1];

                if (!parent.containsKey(friend1)) {
                    parent.put(friend1, friend1);
                    networks.put(friend1, 1);
                }
                if (!parent.containsKey(friend2)) {
                    parent.put(friend2, friend2);
                    networks.put(friend2, 1);
                }

                union(friend1, friend2);
                System.out.println(networks.get(find(friend1)));
            }
        }
    }

    private static void union(String x, String y) {
        String x2 = find(x);
        String y2 = find(y);

        if (!x2.equals(y2)) {
            parent.put(y2, x2);
            int x2Networks = networks.get(x2);
            int y2Networks = networks.get(y2);
            networks.put(x2, x2Networks+y2Networks);
        }
    }

    private static String find(String x) {
        if (x.equals(parent.get(x))) {
            return x;
        }
        String p = find(parent.get(x));
        parent.put(x, p);
        return p;
    }
}
