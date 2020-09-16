package backjun.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1012 {

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int[][] dist;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int loop = 0; loop < testCase; loop++) {
            String[] inputs = br.readLine().split(" ");
            M = Integer.parseInt(inputs[0]);
            N = Integer.parseInt(inputs[1]);
            int itemCount = Integer.parseInt(inputs[2]);

            dist = new int[N][M];

            // dist 초기화
            for (int count = 0; count < itemCount; count++) {
                String[] coords = br.readLine().split(" ");
                dist[Integer.parseInt(coords[1])][Integer.parseInt(coords[0])] = -1;
            }

            int answer = 0;

            // 이중 for문 돌면서 시작점이 가능한 점 찾기
            for (int row = 0; row < N; row++) {
                for (int column = 0; column < M; column++) {
                    if (dist[row][column] == -1) {
                        dfs(row,column);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static int dfs(int row, int column) {
        Queue<int[]> q = new LinkedList<>();
        dist[row][column] = 0;
        q.offer(new int[]{row, column});
        int area = 0;

        while(!q.isEmpty()) {
            int[] location = q.poll();
            area++;

            for (int index = 0; index < 4; index++) {
                int x2 = location[0] + dx[index];
                int y2 = location[1] + dy[index];

                if (x2 < 0 || x2 >= N || y2 < 0 || y2 >= M) continue;
                if (dist[x2][y2] >= 0) continue;
                dist[x2][y2] = dist[location[0]][location[1]] + 1;

                q.offer(new int[]{x2, y2});
            }
        }
        return area;
    }
}
