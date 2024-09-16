package backjun.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N11725 {
    private static List<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] parents = new int[N+1];

        // list 초기화
        for (int index = 0; index < N + 1; index++) {
            list.add(new ArrayList<>());
        }

        // 트리 노드 관계 설정
        for (int loop = 0; loop < N - 1; loop++) {
            String[] relations = br.readLine().split(" ");
            int a = Integer.parseInt(relations[0]);
            int b = Integer.parseInt(relations[1]);
            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs(1, list, parents);

        // 부모노드 출력
        for (int index = 2; index < parents.length; index++) {
            System.out.println(parents[index]);
        }
    }

    // bfs를 진행하면서 각 노드의 부모노드를 parents 배열에 지정한다.
    private static void bfs(int start, List<ArrayList<Integer>> list, int[] parents) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        parents[start] = 1;

        while (!queue.isEmpty()) {
            int parent = queue.poll();

            for (int item : list.get(parent)) {
                if (parents[item] == 0) {
                    parents[item] = parent;
                    queue.offer(item);
                }
            }
        }
    }
}
