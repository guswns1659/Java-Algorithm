package backjun.sorting;

import java.util.*;
import java.io.*;

public class N1991 {

    private static Map<String, List<String>> tree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());

        for (int loop = 0; loop < nodeCount; loop++) {
            String[] nodes = br.readLine().split(" ");
            List<String> children = new ArrayList<>();
            children.add(nodes[1]);
            children.add(nodes[2]);
            tree.put(nodes[0], children);
        }

        preOrder("A");
        System.out.println();
        inOrder("A");
        System.out.println();
        postOrder("A");
    }

    private static void postOrder(String node) {
        if (node.equals(".")) return;

        postOrder(tree.get(node).get(0));
        postOrder(tree.get(node).get(1));
        System.out.print(node);
    }

    private static void inOrder(String node) {
        if (node.equals(".")) return;

        inOrder(tree.get(node).get(0));
        System.out.print(node);
        inOrder(tree.get(node).get(1));
    }

    private static void preOrder(String node) {
        if (node.equals(".")) return;

        System.out.print(node);
        preOrder(tree.get(node).get(0));
        preOrder(tree.get(node).get(1));
    }
}

