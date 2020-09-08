package backjun.bfs;

import java.util.*;
import java.io.*;

public class N1697 {

    // 인덱스 200000을 포함하기 위해 배열 크기를 200001로 초기화한다.
    static int[] dist = new int[200001];
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

                /*
                 * 200000도 배열 인덱스를 벗어나기 때문에 조건문에 포함시켜야 한다. 아니면 배열 크기를 200001로 초기화한다.
                 */
                if (x2 > 200000 || x2 < 0) continue;
                // 이미 방문한 위치! 조건을 0이상으로 해야 한다.
                if (dist[x2] >= 0) continue;
                dist[x2] = dist[location] + 1;
                q.offer(x2);
            }
        }
        return dist[M];
    }
}