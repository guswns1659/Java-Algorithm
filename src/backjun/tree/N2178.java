package backjun.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N2178 {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static boolean[][] visited;
    private static int[][] map;
    private static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int row = 0; row < N; row++) {
            String oneRow = br.readLine();
            for (int column = 0; column < M; column++) {
                map[row][column] = oneRow.charAt(column) - '0';
            }
        }
        bfs(0,0);
        System.out.println(map[N-1][M-1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] location = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int x2 = location[0] + dx[dir];
                int y2 = location[1] + dy[dir];
                if (x2 >= 0 && y2 >= 0 && x2 < N && y2 < M) {
                    if (map[x2][y2] != 0 && !visited[x2][y2]) {
                        queue.offer(new int[]{x2, y2});
                        visited[x2][y2] = true;
                        map[x2][y2] = map[location[0]][location[1]] + 1;
                    }
                }
            }
        }
    }
}
