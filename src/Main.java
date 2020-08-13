import java.util.*;
import java.io.*;

public class Main {

    static Map<Integer, Integer> parent = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            parent.put(i, i);
        }

        union(1,4);
        union(2,4);

        for (int i = 1; i < 5; i++) {
            System.out.println(find(i));
        }
    }

    public static void union(int x, int y) {
        int x2 = find(x);
        int y2 = find(y);

        if (x2 != y2) {
            parent.put(y2, x2);
        }
    }

    private static int find(int x) {
        if (x == parent.get(x)) {
            return x;
        }
        int p = find(parent.get(x));
        parent.put(x, p);
        return parent.get(x);
    }
}