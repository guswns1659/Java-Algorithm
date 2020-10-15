package programmers.graph;

import java.util.*;

public class LongDistanceNode {

    private List<List<Integer>> tree = new ArrayList<>();
    private int[] dist;
    private int[] depth;

    public int solution(int n, int[][] edge) {

        // 트리 생성
        for (int index = 0; index <= n; index++) {
            tree.add(new ArrayList<>());
        }

        // dist 배열 초기화 : -1로
        dist = new int[n+1];
        Arrays.fill(dist, -1);

        depth = new int[n+1];

        // 트리 초기화
        for (int[] nodes : edge) {
            int a = nodes[0];
            int b = nodes[1];
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        return bfs(1);
    }

    private int bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        dist[root] = 0;

        int maxDepth = -1;
        int leafCount = 0;

        while(!q.isEmpty()) {
            int current = q.poll();

            if (maxDepth < depth[current]) {
                maxDepth = depth[current];
                leafCount = 1;

            } else if (maxDepth == depth[current]) {
                leafCount++;
            }

            for (int next : tree.get(current)) {

                if (dist[next] >= 0) continue;
                dist[next] = dist[current] + 1;
                depth[next] = depth[current] + 1;
                q.offer(next);
            }
        }
        return leafCount;
    }
}
