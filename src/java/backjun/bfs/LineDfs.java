package backjun.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LineDfs {

    static int[] conyDist = new int[200001];
    static int[] brownDist = new int[200001];
    static int C, B;
    static int second = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        // 코니위치
        C = Integer.parseInt(NM[0]);
        // 브라운위치
        B = Integer.parseInt(NM[1]);

        Arrays.fill(conyDist, -1);
        Arrays.fill(brownDist, -1);

        System.out.println(test(C, B));
    }

    public static int test(int c, int b) {
        // main으로 실행할 땐 지워야하는 조건들
        C = c;
        B = b;
        Arrays.fill(conyDist, -1);
        Arrays.fill(brownDist, -1);

        Queue<Integer> q = new LinkedList<>();
        conyDist[c] = 0;
        brownDist[b] = 0;
        q.offer(b);

        /*
         * 문제의 원인 q.poll()할 때마다 초가 증가하는데 q.poll()할 때 초가 증가하는 것이 아니라 트리의 깊이의 해당하는 노드가 끝났을 때 추가해야함.
         */

        while (true) {
            second++;
            int conyLocation = getConyLocation(second + 1);
            if (conyLocation > 200000) return -1;
            conyDist[conyLocation] = second;

            for (int brownLocation : q) {
                // 브라운이 해당 위치에 도달한 시간과 현재 시간이 같을 때만 코니 위치와 브라운의 위치가 같은지 판단한다.
                if (conyLocation == brownLocation && conyDist[conyLocation] == brownDist[brownLocation]) {
                    return second;
                }
            }

            // 안에 for문을 돌고 while문으로 갈 줄 알았는데 q가 채워지니 다시 바깥 for문으로 나온다.
            int size = q.size();
            for (int index = 0; index < size; index++) {
                int brownLocation = q.poll();
                int brownLocation2;

                for (int loop = 1; loop < 4; loop++) {
                    if (loop == 1 ) brownLocation2 = brownLocation - 1;
                    else if (loop == 2) brownLocation2 = brownLocation + 1;
                    else brownLocation2 = brownLocation * 2;

                    if (brownLocation2 > 200000 || brownLocation2 < 0) continue;
                    if (brownDist[brownLocation2] >= 0) continue;
                    brownDist[brownLocation2] = brownDist[brownLocation] + 1;
                    q.offer(brownLocation2);
                }
            }
        }
    }

    private static int getConyLocation(int num) {
        if (num <= 1) {
            return C;
        }
        return getConyLocation(num - 1) + num - 1;
    }
}
