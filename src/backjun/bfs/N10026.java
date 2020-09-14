package backjun.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N10026 {

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static char[][] map;
    static char[][] secondMap;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        secondMap = new char[N][N];
        visited = new boolean[N][N];
        int answer1 = 0;
        int answer2 = 0;

        // map, secondMap 초기화
        for (int r = 0; r < N; r++) {
            String oneRow = br.readLine();
            for (int c = 0; c < N; c++) {
                char color = oneRow.charAt(c);
                if (color == 'R') {
                    map[r][c] = 'R';
                    secondMap[r][c] = 'R';
                } else if (color == 'B') {
                    map[r][c] = 'B';
                    secondMap[r][c] = 'B';
                } else {
                    map[r][c] = 'G';
                    secondMap[r][c] = 'R';
                }
            }
        }

        // 적록색약 아닌 dfs 실행
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c]) {
                    dfs(r, c, map);
                    answer1++;
                }
            }
        }

        visited = new boolean[N][N];

        // 적록색약 dfs 실행
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c]) {
                    dfs(r, c, secondMap);
                    answer2++;
                }
            }
        }
        System.out.print(answer1 + " " + answer2);
    }

    private static void dfs(int r, int c, char[][] map) {
        Queue<int[]> q = new LinkedList<>();
        char color = map[r][c];
        visited[r][c] = true;
        q.offer(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] location = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int x2 = location[0] + dx[dir];
                int y2 = location[1] + dy[dir];

                if (x2 < 0 || x2 >= N || y2 < 0 || y2 >= N) continue;
                // 이미 방문했거나 시작점 컬러와 다른 경우
                if (visited[x2][y2] || map[x2][y2] != color) continue;
                visited[x2][y2] = true;
                q.offer(new int[]{x2,y2});
            }
        }
    }
}
