package backjun.hash;

import java.util.*;

class LastPoint {

    public static void main(String[] args) {
        int[][] v = new int[][]{{1,4},{3,4},{3,10}};
        System.out.println(Arrays.toString(solution(v)));
    }

    public static int[] solution(int[][] v) {
        int x = v[0][0]^v[1][0]^v[2][0];
        int y = v[0][1]^v[1][1]^v[2][1];

        return new int[]{x, y};
    }
}