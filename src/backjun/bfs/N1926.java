package backjun.bfs;

import java.util.*;
import java.io.*;

public class N1926 {

    private static int[] dx = new int[]{1,-1,0,0};
    private static int[] dy = new int[]{0,0,1,-1};
    private static int[][] dist;
    private static int N,M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        // dist 생성 및 초기화
        dist = new int[N][M];

        for (int r = 0; r < N; r++) {
            String[] input = br.readLine().split(" ");
            for (int c = 0; c < M; c++) {
                String character = input[c];
                if (!character.equals("0")) {
                    dist[r][c] = -1;
                }
            }
        }

        // for문 돌며 bfs(), 돌 때 마다 count++;
        // bfs()의 결과인 size와 max를 비교 
        int count = 0;
        int max = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (dist[r][c] == -1) {
                    int size = bfs(r,c);
                    count++;
                    if (size > max) {
                        max = size;
                    }
                }
            }
        }

        System.out.println(count);
        System.out.println(max);


    }

    private static int bfs(int x, int y) {
        int size = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        dist[x][y] = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            size++;
            int x2 = current[0];
            int y2 = current[1];

            for (int dir = 0; dir < 4; dir++) {
                int x3 = x2 + dx[dir];
                int y3 = y2 + dy[dir];

                // 배열 벗어나는 조건
                if (x3 < 0 || x3 >= N || y3 < 0 || y3 >= M) continue;
                // 방문한 조건
                if (dist[x3][y3] >= 0) continue;
                dist[x3][y3] = dist[x2][y2] + 1;
                q.offer(new int[]{x3,y3});


            }
        }
        return size;
    }

}