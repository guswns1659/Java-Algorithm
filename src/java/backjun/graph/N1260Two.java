package backjun.graph;

import java.util.*;
import java.io.*;

public class N1260Two {

    // 자료구조 선언
    private static List<List<Integer>> graphs = new ArrayList<>();
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NMS = br.readLine().split(" ");
        int N = Integer.parseInt(NMS[0]);
        int M = Integer.parseInt(NMS[1]);
        int S = Integer.parseInt(NMS[2]);

        // 그래프, dist 초기화
        for (int index = 0; index < N+1; index++) {
            graphs.add(new ArrayList<>());
        }

        dist = new int[N+1];
        Arrays.fill(dist, -1);

        // 그래프 설정
        for (int loop = 0; loop < M; loop++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            graphs.get(a).add(b);
            graphs.get(b).add(a);


        }

        System.out.println(dfs(S));

        Arrays.fill(dist, -1);
        System.out.println(bfs(S));

    }

    // dfs
    private static String dfs(int root) {
        Stack<Integer> s = new Stack<>();
        s.push(root);

        StringBuilder answer = new StringBuilder();

        while(!s.isEmpty()) {
            int current = s.pop();
            if (dist[current] >= 0) continue;
            dist[current] = 0;
            answer.append(current + " "); // pop() 한 뒤 answer에 추가한다
            List<Integer> nexts = graphs.get(current);
            Collections.sort(nexts, Collections.reverseOrder()); // dfs에서 작은 숫자 먼저 나오려면 인접리스트를 역순으로 정렬 
            for (int next : nexts) { //** pop()할 때만 방문표시를 해야 정상적으로 처리
                if (dist[next] >=0) continue; // 방문 노드라면 제외 
                // dist[next] = dist[current] + 1;
                s.push(next);
            }
        }
        return answer.toString();
    }

    // bfs
    private static String bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        dist[root] = 0;
        StringBuilder answer = new StringBuilder();

        while(!q.isEmpty()) {
            int current = q.poll();
            answer.append(current + " "); // poll() 한 뒤 answer에 추가한다
            List<Integer> nexts = graphs.get(current);
            Collections.sort(nexts); // bfs에서 작은 숫자 먼저 나오려면 인접리스트를 오름차순 정렬 
            for (int next : nexts) {
                if (dist[next] >=0) continue; // 방문 노드라면 제외 
                dist[next] = dist[current] + 1;
                q.offer(next);
            }
        }
        return answer.toString();
    }

}