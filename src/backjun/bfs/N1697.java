package backjun.bfs;

import java.util.*;
import java.io.*;

public class N1697 {

    static int[] dist = new int[200000];
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(dist, -1);

        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        System.out.print(dfs(N));
    }

    public static int dfs(int N) {
        Queue<Integer> q = new LinkedList<>();
        dist[N] = 0;
        q.offer(N);

        // while문 조건을 dist[M] = -1일 때까지만 해야지 런타임 에러를 방지할 수 있다. 불필요한 연산 줄임.
        while (dist[M] == -1) {
            int location = q.poll();

            int x2;

            for (int loop = 1; loop < 4; loop++) {
                if (loop == 1) {
                    x2 = location - 1;
                } else if (loop == 2) {
                    x2 = location + 1;
                } else {
                    x2 = location * 2;
                }

                if (x2 > 100000 || x2 < 0) continue;
                // 이미 방문한 위치
                if (dist[x2] >= 0) continue;
                dist[x2] = dist[location] + 1;
                q.offer(x2);
            }
        }
        return dist[M];
    }
}