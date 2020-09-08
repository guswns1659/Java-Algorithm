package backjun.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N4179 {

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static char[][] map;
    static int[][] fireStatus;
    static int[][] personStatus;
    static int[] personStart;
    static int[] fireStart;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        map = new char[N][M];
        fireStatus = new int[N][M];
        personStatus = new int[N][M];

        // map, fireStatus, personStatus 초기화
        for (int r = 0; r < N; r++) {
            String oneRow = br.readLine();
            for (int c = 0; c < M; c++) {
                char mapStatus = oneRow.charAt(c);
                map[r][c] = mapStatus;

                if (mapStatus == 'J') {
                    personStart = new int[]{r, c};
                    personStatus[r][c] = 0;
                    fireStatus[r][c] = -1;
                } else if (mapStatus == 'F') {
                    fireStart = new int[]{r, c};
                    personStatus[r][c] = 0;
                    fireStatus[r][c] = 0;
                } else if (mapStatus == '.') {
                    personStatus[r][c] = -1;
                    fireStatus[r][c] = -1;
                } else {
                    personStatus[r][c] = 0;
                    fireStatus[r][c] = 0;
                }
            }
        }

        // 각 불과 사람 dfs를 실행한다.
        fireDfs(fireStart[0], fireStart[1]);
        int result = personDfs(personStart[0], personStart[1]);
        if (result == -1) {
            System.out.print("IMPOSSIBLE");
        } else {
            System.out.print(result);
        }
    }

    // 불 dfs
    private static void fireDfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] location = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int x2 = location[0] + dx[dir];
                int y2 = location[1] + dy[dir];
                if (x2 < 0 || x2 >= N || y2 < 0 || y2 >= M) continue;
                if (fireStatus[x2][y2] >= 0 || map[x2][y2] == '#') continue;
                queue.offer(new int[]{x2, y2});
                fireStatus[x2][y2] = fireStatus[location[0]][location[1]] + 1;
            }
        }
    }

    // 사람 dfs
    private static int personDfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] location = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int x2 = location[0] + dx[dir];
                int y2 = location[1] + dy[dir];
                // 배열을 벗어났을때가 가장 빨리 탈출했을 때!!
                if (x2 < 0 || x2 >= N || y2 < 0 || y2 >= M) return personStatus[location[0]][location[1]] + 1;
                if (personStatus[x2][y2] >= 0 || map[x2][y2] == '#') continue;
                queue.offer(new int[]{x2, y2});
                personStatus[x2][y2] = personStatus[location[0]][location[1]] + 1;
                // fireStatus의 값과 비교해서 작은 값만 남긴다. (불보다 빨리 도착함)
                if (personStatus[x2][y2] >= fireStatus[x2][y2]) {
                    personStatus[x2][y2] = 0;
                }
            }
        }
        return -1;
    }
}
