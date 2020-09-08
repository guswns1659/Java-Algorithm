package backjun.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N7576 {

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int[][] map;
    static int[][] dist;
    static int M, N;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] MN = br.readLine().split(" ");
        M = Integer.parseInt(MN[0]);
        N = Integer.parseInt(MN[1]);

        map = new int[N][M];
        dist = new int[N][M];

        // map과 dist 초기화
        for (int row = 0; row < N; row++) {
            String[] oneRow = br.readLine().split(" ");
            for (int column = 0; column < M; column++) {
                int tomatoStatus = Integer.parseInt(oneRow[column]);
                map[row][column] = tomatoStatus;
                if (tomatoStatus == 1) {
                    q.offer(new int[]{row, column});
                }
                if (tomatoStatus == 0) {
                    dist[row][column] = -1;
                }
            }
        }

        // dfs 과정, 모든 시작점으로부터 거리 구함
        while (!q.isEmpty()) {
            int[] location = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int x2 = location[0] + dx[dir];
                int y2 = location[1] + dy[dir];

                if (x2 < 0 || x2 >= N || y2 < 0 || y2 >= M) continue;
                // 익은 토마토거나 비어있는 경우
                if (dist[x2][y2] >= 0 || map[x2][y2] != 0) continue;
                q.offer(new int[]{x2,y2});
                dist[x2][y2] = dist[location[0]][location[1]] + 1;
            }
        }

        /*
         * dist를 돌면서 -1이 있으면 안 익은 토마토가 있는 상황이라 -1 출력
         * 그 외에는 없는 토마토거나 익은 토마토가 있는 상황이라 최대값을 출력한다.
         */
        int max = 0;
        boolean flag = true;
        for (int row = 0; row < N; row++) {
            for (int column = 0; column < M; column++) {
                if (dist[row][column] == -1) {
                    flag = false;
                }
                max = Math.max(max, dist[row][column]);
            }
        }

        if (!flag) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
    }
}
