package backjun.hash;

import java.util.*;

class LastPoint {

    public static void main(String[] args) {
        int[][] v = new int[][]{{1,4},{3,4},{3,10}};
        System.out.println(Arrays.toString(solution(v)));
    }

    public static int[] solution(int[][] v) {
        HashMap<Integer, Integer> xCoord = new HashMap<>();
        HashMap<Integer, Integer> yCoord = new HashMap<>();
        int x = 0;
        int y = 0;

        for (int[] coord : v) {
            xCoord.merge(coord[0], 1, Integer::sum);
            yCoord.merge(coord[1], 1, Integer::sum);
        }

        for (int key : xCoord.keySet()) {
            if (xCoord.get(key) == 1) x = key;
        }
        for (int key : yCoord.keySet()) {
            if (yCoord.get(key) == 1) y = key;
        }

        return new int[]{x, y};
    }
}