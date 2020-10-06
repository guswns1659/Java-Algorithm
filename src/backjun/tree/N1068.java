package backjun.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N1068 {
    private static Map<Integer, List<Integer>> tree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] parents = br.readLine().split(" ");
        int root = 0;

        // tree 초기화
        for (int loop = 0; loop < N; loop++) {
            tree.put(loop, new ArrayList<>());
        }

        /**
         * 주어진 노드로 부모 노드와의 관계 성립
         * ex) {0 = [1], 1 = [2] , 2 = []}
         */
        for (int index = 0; index < parents.length; index++) {
            int parent = Integer.parseInt(parents[index]);
            if (parent == -1) {
                root = index;
            } else {
                tree.get(parent).add(index);
            }
        }

        int removeNode = Integer.parseInt(br.readLine());
        remove(removeNode);
//        System.out.println(tree);
        System.out.println(countLeaf(root, 0));
    }

    // 지울 노드와 그 자식들을 지운다.
    private static void remove(int remove) {
        if (tree.get(remove).size() == 0) {
            tree.remove(remove);
            return;
        }
        for (int value : tree.get(remove)) {
            remove(value);
        }
        tree.remove(remove);
    }

    private static int countLeaf(int key, int sum) {
        if (!tree.containsKey(key)) return 0;
        if (tree.get(key).size() == 0) return 1;
        for (int value : tree.get(key)) {
            sum += countLeaf(value, 0);
        }
        // 자식이 죽은 노드인데 개 하나 밖에 없었다면 1을 리턴
        if (sum == 0 && tree.get(key).size() == 1) {
            return sum + 1;
        }
        return sum;
    }
}
