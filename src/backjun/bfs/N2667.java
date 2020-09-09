package backjun.bfs;

import java.util.*;
import java.io.*;

public class N2667 {

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int[][] dist;
    static List<Integer> zones = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        N = Integer.parseInt(input);

        dist = new int[N][N];

        // dist 초기화
        for (int row = 0; row < N; row++) {
            String oneRow = br.readLine();
            for (int column = 0; column < N; column++) {
                int mapStatus= oneRow.charAt(column) - '0';
                if (mapStatus == 0) {
                    dist[row][column] = 0;
                } else {
                    dist[row][column] = -1;
                }
            }
        }

        // 이중 for문 돌면서 시작점이 가능한 점 찾기
        for (int row = 0; row < N; row++) {
            for (int column = 0; column < N; column++) {
                // 1이 아니거나 이미 방문한 노드면 continue;
                if (dist[row][column] >= 0) continue;
                zones.add(dfs(row,column));
            }
        }

        Collections.sort(zones);

        System.out.println(zones.size());
        zones.forEach(System.out::println);
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

                if (x2 < 0 || x2 >= N || y2 <0 || y2 >= N) continue;
                if (dist[x2][y2] >= 0) continue;
                dist[x2][y2] = dist[location[0]][location[1]] + 1;

                q.offer(new int[]{x2, y2});
            }
        }
        return area;
    }
}
