package backjun.tree;

import java.util.*;
import java.io.*;

public class N15900 {

    private static Map<Integer, List<Integer>> tree = new HashMap<>();
    private static int[] depth;
    private static int[] parent;
    private static List<Integer> leafIndex = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int treeCount = Integer.parseInt(br.readLine());
        depth = new int[treeCount+1];
        parent = new int[treeCount+1];

        // 트리 초기화
        for (int num = 0; num < treeCount; num++ ) {
            tree.put(num + 1, new ArrayList<>());
        }
        // 루트 노트 부모로 0 추가
        tree.get(1).add(0);

        // 트리 생성
        for (int loop = 0; loop < treeCount - 1; loop++) {
            String[] nodes= br.readLine().split(" ");
            int a = Integer.parseInt(nodes[0]);
            int b = Integer.parseInt(nodes[1]);
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        if (bfs(1) % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

    }
    public static int bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(root);
        int count = 0;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int next : tree.get(current)) {
                if (tree.get(current).size() == 1) {
                    count += depth[current];
                    break;
                }
                if (parent[current] == next) continue;
                parent[next] = current;
                q.offer(next);
                depth[next] = depth[current] + 1;
            }
        }
        return count;
    }
}