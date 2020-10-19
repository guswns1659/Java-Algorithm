package backjun.graph;

import java.util.*;
import java.io.*;

public class N11724Two {

    // 필요한 자료구조 선언
    private static List<List<Integer>> trees = new ArrayList<>();
    private static int[] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        // dist, trees 초기화 -> get(index)가 아니라 add()로 추가한다.
        dist = new int[N+1];
        Arrays.fill(dist, -1);
        for (int index = 0; index < N+1; index++) {
            trees.add(new ArrayList<>());
        }

        // 트리 추가
        for (int loop = 0; loop < M; loop++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);

            trees.get(a).add(b);
            trees.get(b).add(a);
        }

        // bfs 순회 -> 방문하지 않는 노드를 시작 노드로
        int answer = 0;
        for (int index = 1; index < trees.size(); index++) {
            if (dist[index] >= 0) continue; // 방문한 노드라면 건너뛴다
            Queue<Integer> q = new LinkedList<>();
            q.offer(index); // 방문하지 않은 노드를 시작점으로
            answer++; // bfs 순회할 때마다 하나의 네트워크는 모두 순회하니까 answer++ 한다.
            dist[index] = 0;
            while (!q.isEmpty()) {
                int current = q.poll();
                for (int next : trees.get(current)) {
                    if (dist[next] >= 0) continue; // 꺼낸 노드가 방문한 노드라면
                    dist[next] = dist[current] + 1;
                    q.offer(next);
                }
            }

        }
        System.out.println(answer);
    }
}
