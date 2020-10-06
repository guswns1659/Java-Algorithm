package backjun.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TreeNode {

    public TreeNode left;
    public Integer value;
    public TreeNode right;

    public TreeNode(Integer value) {
        this(null, value, null);
    }

    public TreeNode(TreeNode left, Integer value, TreeNode right) {
        this.left = left;
        this.value = value;
        this.right = right;
    }

    public boolean isLeftOf(TreeNode current) {
        return this.value < current.value;
    }
}


class BinarySearchTree {

    public TreeNode head;
    private int size;

    public BinarySearchTree(TreeNode head) {
        this.head = head;
        this.size++;
    }

    public boolean add(TreeNode newNode) {
        TreeNode current = this.head;

        while (true) {
            if (newNode.isLeftOf(current)) {
                if (current.left == null) {
                    current.left = newNode;
                    this.size++;
                    return true;
                }
                current = current.left;

            } else {
                if (current.right == null) {
                    current.right = newNode;
                    this.size++;
                    return true;
                }
                current = current.right;
            }
        }
    }

    public void postorder(TreeNode treeNode) {
        if (treeNode.left != null) postorder(treeNode.left);
        if (treeNode.right != null) postorder(treeNode.right);
        System.out.println(treeNode.value);
    }
}


public class N5639 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nodes = new ArrayList<>();
        int rootNode = scanner.nextInt();

        while (scanner.hasNext()) {
            try {
                int value = scanner.nextInt();
                nodes.add(value);
            } catch (Exception e) {
                break;
            }
        }

        solution(new TreeNode(rootNode), nodes);
    }

    public static void solution(TreeNode treeNode, List<Integer> nodes) {
        // 이진 탐색 트리 생성
        BinarySearchTree binarySearchTree = new BinarySearchTree(treeNode);

        // 이진 탐색 트리 구현
        for (int index = 0; index < nodes.size(); index++) {
            binarySearchTree.add(new TreeNode(nodes.get(index)));
        }

        binarySearchTree.postorder(binarySearchTree.head);
    }
}
