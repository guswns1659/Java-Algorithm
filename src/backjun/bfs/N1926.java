package backjun.bfs;

import java.util.*;
import java.io.*;

public class N1926 {

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        visited = new boolean[N][M];

        int drawingCount = 0;
        int maxArea = 0;

        // map 초기화
        for (int row = 0; row < N; row++) {
            String[] oneRow = br.readLine().split(" ");
            for (int column = 0; column < M; column++) {
                map[row][column] = Integer.parseInt(oneRow[column]);
            }
        }

        for (int row = 0; row < N; row++) {
            for (int column = 0; column < M; column++) {
                // 1이 아니거나 이미 방문한 노드면 continue;
                if (map[row][column] != 1 || visited[row][column]) continue;
                maxArea = Math.max(dfs(row,column), maxArea);
                drawingCount++;
            }
        }

        System.out.println(drawingCount);
        System.out.print(maxArea);
    }

    public static int dfs(int row, int column) {

        Queue<int[]> q = new LinkedList<>();
        visited[row][column] = true;
        q.offer(new int[]{row, column});
        int area = 0;

        while(!q.isEmpty()) {
            int[] location = q.poll();
            area++;

            for (int index = 0; index < 4; index++) {
                int x2 = location[0] + dx[index];
                int y2 = location[1] + dy[index];

                if (x2 < 0 || x2 >= N || y2 <0 || y2 >= M) continue;
                if (map[x2][y2] != 1 || visited[x2][y2]) continue;

                visited[x2][y2] = true;
                q.offer(new int[]{x2, y2});
            }
        }
        return area;
    }
}
