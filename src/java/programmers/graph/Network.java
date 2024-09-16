package programmers.graph;

import java.util.*;

public class Network {

    private Map<Integer, Integer> parent;

    public int solution(int n, int[][] computers) {
        parent = new HashMap<>();

        for (int row = 1; row < computers.length + 1; row++) {
            parent.put(row, row);
        }

        for (int row = 0; row < computers.length; row++) {
            for(int column = 0; column < computers[row].length; column++) {
                if (computers[row][column] == 0) continue;
                if (row >= column) continue;
                union(row + 1, column + 1);
            }
        }

        for (int index = 1; index < computers.length + 1; index++) {
            find(index);
        }

        Set<Integer> set = new HashSet<>();

        for (int value : parent.values()) {
            set.add(value);
        }

        return set.size();
    }

    public void union(int x, int y) {
        int x2 = find(x);
        int y2 = find(y);

        if (x2 != y2) {
            parent.put(y2, x2);
        }
    }

    public int find(int x) {
        if (x == parent.get(x)) {
            return x;
        }

        int p = find(parent.get(x));
        parent.put(x, p);
        return p;
    }

}