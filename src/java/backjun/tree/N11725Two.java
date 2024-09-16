package backjun.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N11725Two {

    private static Map<Integer, List<Integer>> tree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // tree 초기화
        for (int index = 1; index < N + 1; index++) {
            tree.put(index, new ArrayList<>());
        }

        // 인덱스가 N까지 필요하기 때문
        int[] parents = new int[N+1];

        // 입력값에 따른 tree 셋팅
        for (int loop = 0; loop < N-1; loop++) {
            String[] relations = br.readLine().split(" ");
            int node1 = Integer.parseInt(relations[0]);
            int node2 = Integer.parseInt(relations[1]);

            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }

        // parents를 넣는 이유는 전역 변수로 지정할 수 없기 때문이다.
        bfs(1, parents);

        // 부모 배열 출력
        for (int index = 2; index < parents.length; index++) {
            System.out.println(parents[index]);
        }
    }

    private static void bfs(int root, int[] parents) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : tree.get(current)) {
                if (parents[current] == next) continue;
                parents[next] = current;
                queue.offer(next);
            }
        }
    }
}
