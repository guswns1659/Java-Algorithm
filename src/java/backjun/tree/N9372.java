package backjun.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N9372 {

    private static Map<Integer, List<Integer>> tree = new HashMap<>();
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int loop = 0; loop < testCase; loop++) {
            String[] nationAndPlane = br.readLine().split(" ");
            int nation = Integer.parseInt(nationAndPlane[0]);
            int planeCount = Integer.parseInt(nationAndPlane[1]);
            // 부모 배열을 둬서 중복 체크하지 않는 처리, node 개수만큼 인덱스로 접근하려면 +1 한다.
            // 매 테스트 케이스마다 트리와 dist 초기화
            initTreeAndDist(nation);

            for (int num = 1; num < planeCount + 1; num++) {
                String[] nodes = br.readLine().split(" ");
                tree.get(Integer.parseInt(nodes[0])).add(Integer.parseInt(nodes[1]));
                tree.get(Integer.parseInt(nodes[1])).add(Integer.parseInt(nodes[0]));
            }
            System.out.println(bfs(1));
        }
    }

    private static void initTreeAndDist(int nationCount) {
        // dist 초기화
        dist = new int[nationCount + 1];
        Arrays.fill(dist, -1);

        //  tree 초기화
        for (int node = 1; node < nationCount + 1; node++) {
            tree.put(node, new ArrayList<>());
        }

    }

    private static int bfs(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        dist[root] = 0;
        int count = -1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            for (int next : tree.get(current)) {
                // 한번 방문한 노드라면
                if (dist[next] >= 0) continue;
                dist[next] = dist[current] + 1;
                queue.offer(next);
            }
        }
        return count;
    }
}
