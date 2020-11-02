package backjun.bfs;

import java.util.*;
import java.io.*;

public class N2178 {

    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, 1, -1};
    private static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        // dist 생성 및 초기화
        dist = new int[N][M];
//        Arrays.fill(dist, -1); // fill은 배열 한개에만 적용된다. 2차원 배열인 경우 반복문으로 해결

        for (int r = 0; r < N; r++) {
            String input = br.readLine();
            for (int c = 0; c < M; c++) {
                char character = input.charAt(c);
                if (character != '0') {
                    dist[r][c] = -1;
                }
            }
        }

        // bfs 
        Queue<int[]> q = new LinkedList<>();
        dist[0][0] = 1;
        q.offer(new int[]{0,0});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            // 동서남북으로 이동
            for (int dir = 0; dir < 4; dir++) {
                int x2 = x + dx[dir];
                int y2 = y + dy[dir];

                // 배열을 벗어나면 continue;
                if (x2 < 0 || x2 >= N || y2 < 0 || y2 >= M) continue;
                // 방문한 노드라면 continue;
                if (dist[x2][y2] >= 0) continue;
                dist[x2][y2] = dist[x][y] + 1;
                q.offer(new int[]{x2, y2});
            }
        }

        System.out.println(dist[N-1][M-1]);
    }
}