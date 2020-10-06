package backjun.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class N1991 {

    private static Map<String, Integer> nodes = new HashMap<>();
    private static String[] lc;
    private static String[] rc;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lc = new String[N + 1];
        rc = new String[N + 1];

        /**
         *  inputs으로 nodes, lc, rc 초기화하기
         */
        for (int index = 1; index < N + 1; index++) {
            String[] inputs = br.readLine().split(" ");
            nodes.put(inputs[0], index);
            lc[index] = inputs[1];
            rc[index] = inputs[2];
        }

        preorder("A");
        System.out.println();
        inorder("A");
        System.out.println();
        postorder("A");
    }

    private static void postorder(String node) {
        int index = nodes.get(node);
        if (!lc[index].equals(".")) postorder(lc[index]);
        if (!rc[index].equals(".")) postorder(rc[index]);
        System.out.print(node);
    }

    private static void inorder(String node) {
        int index = nodes.get(node);
        if (!lc[index].equals(".")) inorder(lc[index]);
        System.out.print(node);
        if (!rc[index].equals(".")) inorder(rc[index]);
    }

    private static void preorder(String node) {
        int index = nodes.get(node);
        System.out.print(node);
        if (!lc[index].equals(".")) preorder(lc[index]);
        if (!rc[index].equals(".")) preorder(rc[index]);
    }
}
