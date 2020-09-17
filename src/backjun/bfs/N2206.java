package backjun.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int row, col;
    int breakCount;

    public Node(int row, int col, int breakCount) {
        this.row = row;
        this.col = col;
        this.breakCount = breakCount;
    }
}
public class N2206 {

    // 그래프의 정보를 나타내는 배열
    static int[][] map;
    // 이동한 거리를 저장할 배열
    static int[][] dist;
    /*
     * 벽을 부쉰 횟수를 저장할 배열
     * 미방문 = 2, 한번 벽을 부쉰 노드 = 1, 벽을 부쉰적 없는 노드 = 0
     */
    static int[][] wallMap;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        // map 초기화
        map = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];
        wallMap = new int[N + 1][M + 1];

        // 벽을 부쉰 횟수를 2로 초기화한다
        for (int[] row : wallMap) {
            Arrays.fill(row, 2);
        }

        // 입력 값을 배열에 초기화한다.
        for (int r = 1; r <= N; r++) {
            String oneRow = br.readLine();
            for (int c = 1; c <= M; c++) {
                map[r][c] = oneRow.charAt(c - 1) - '0';
            }
        }

        int answer = bfs();
        System.out.println(answer);

    }

    public static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        // (1,1) 시작 노드를 큐에 추가하고 벽을 부순횟수는 0으로 초기화한다. 아직 벽을 부수지 않았기 때문
        queue.add(new Node(1,1, 0));
        dist[1][1] = 1;
        wallMap[1][1] = 0;

        while (!queue.isEmpty()){
            // 큐에서 노드를 꺼낸다.
            Node curNode = queue.poll();
            // 꺼낸 노드가 (m,n) 좌표일 경우 최단거리 값을 반환한다.
            if(curNode.row == N && curNode.col == M) return dist[N][M];

            for(int i = 0; i < 4; i++){
                // 상하좌우 노드의 행,열 값
                int row = curNode.row + dx[i];
                int col = curNode.col + dy[i];

                // 벽인 경우
                if(isRightNode(row, col) && isWall(row, col)){
                    // 현재 노드가 부신 벽의 개수가 0일 경우만 실행
                    if(curNode.breakCount == 0){
                        queue.add(new Node(row, col, 1));
                        dist[row][col] = dist[curNode.row][curNode.col] + 1;
                        // 벽을 만났으므로 벽을 부쉰 횟수는 1이 된다.
                        dist[row][col] = 1;
                    }
                    // 벽이 아닌 경우
                }else if(isRightNode(row, col) && !isWall(row, col)){
                    // 이동할 노드의 벽을 부신 횟수가 1인경우 : 현재 노드가 벽을 부신 횟수가 0인 경우만 큐에 추가
                    // 이동할 노드의 벽을 부신 횟수가 2인경우 : 미방문이므로 현재 노드가 벽을 부신 횟수가 0, 1 둘다 큐에 추가
                    if(wallMap[row][col] > curNode.breakCount) {
                        queue.add(new Node(row, col, curNode.breakCount));
                        dist[row][col] = dist[curNode.row][curNode.col] + 1;
                        wallMap[row][col] = curNode.breakCount;
                    }
                }
            }
        }

        // 반복문 중간에 66번라인이 실행되지 않았다는 것은 (m,n)에 도달하지 못했다는 것이다.
        return -1;
    }
    // (1,1) ~ (n,m)의 범위에 있을 경우 true 반환
    public static boolean isRightNode(int row,int col){
        if(row < 1 || row > N || col < 1 || col > M) return false;
        else return true;
    }
    // 벽인 경우 true 반환
    public static boolean isWall(int row, int col){
        if(map[row][col] == 1) return true;
        else return false;
    }
}
