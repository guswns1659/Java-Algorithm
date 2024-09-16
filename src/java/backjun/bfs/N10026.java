package backjun.bfs;

import java.util.*;
import java.io.*;

public class N10026 {

    private static int[] dx = new int[]{1,-1,0,0};
    private static int[] dy = new int[]{0,0,1,-1};
    private static int[][] map;
    private static int[][] distA;
    private static int[][] distB;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int countA = 0;
        int countB = 0;

        // map, dist 생성 및 초기화
        map = new int[N][N];
        distA = new int[N][N];
        distB = new int[N][N];

        for (int r = 0; r < N; r++) {
            String input = br.readLine();
            for (int c = 0; c < N; c++) {
                distA[r][c] = -1;
                distB[r][c] = -1;
                char character = input.charAt(c);
                if (character == 'R') {
                    map[r][c] = 1;
                } else if (character == 'G') {
                    map[r][c] = 2;
                } else {
                    map[r][c] = 3;
                }
            }
        }

        // 적록색약인 경우와 아닌 경우 모두 bfs
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (distA[r][c] == -1) {
                    bfsA(r,c,map[r][c]);
                    countA++;
                }
                if (distB[r][c] == -1) {
                    bfsB(r,c,map[r][c]);
                    countB++;
                }
            }
        }

        System.out.println(countA);
        System.out.println(countB);

    }

    // 적록색약X bfs
    private static void bfsA(int x, int y, int color) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        distA[x][y] = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int x2 = current[0] + dx[dir];
                int y2 = current[1] + dy[dir];


                // 배열 벗어난 경우
                if (x2 < 0 || x2 >= N || y2 < 0 || y2 >=N) continue;
                // 방문한 노드거나 다른 색깔인 경우
                if (distA[x2][y2] >= 0 || map[x2][y2] != color) continue;
                distA[x2][y2] = distA[x][y] + 1;
                q.offer(new int[]{x2,y2});

            }
        }
    }

    // 적록색약O bfs
    private static void bfsB(int x, int y, int color) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        distB[x][y] = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int x2 = current[0] + dx[dir];
                int y2 = current[1] + dy[dir];


                // 배열 벗어난 경우
                if (x2 < 0 || x2 >= N || y2 < 0 || y2 >=N) continue;
                // 방문한 노드
                if (distB[x2][y2] >= 0) continue;
                // color가 빨간색 또는 초록색인 경우 이웃 색깔이 파란색일 때 넘어가기
                if (color == 1 || color == 2) {
                    if (map[x2][y2] == 3) continue;
                } else {
                    if (map[x2][y2] != color) continue;
                }
                distB[x2][y2] = distB[x][y] + 1;
                q.offer(new int[]{x2,y2});

            }
        }
    }
}