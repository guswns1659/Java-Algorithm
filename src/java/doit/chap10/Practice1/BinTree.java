package doit.chap10.Practice1;

import java.util.Comparator;

public class BinTree<K, V> {
    private Node<K, V> root;
    private Comparator<? super K> comparator = null;

    // 노드
    static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;

        Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        void print() {
            System.out.println(value);
        }
    }

    // 자연 순서에 따라 키 값을 비교
    public BinTree() {
        root = null;
    }

    // 비교자로 키 값을 비교
    public BinTree(Comparator<? super K> c) {
        this();
        comparator = c;
    }

    public int compare(K key1, K key2) {
        return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) : (comparator.compare(key1, key2));
    }

    public V search(K key) {
        Node<K, V> pointer = root;
        while (true) {
            if (pointer == null) return null;
            int condition = compare(key, pointer.getKey());
            if (condition == 0) return pointer.getValue();
            else if (condition < 0) pointer = pointer.left;
            else pointer = pointer.right;
        }
    }

    public boolean add(K key, V value) {
        if (root == null) {
            root = new Node(key, value, null, null);
            return true;
        }
        return addNode(root, key, value);
    }

    public boolean addNode(Node<K, V> node, K key, V value) {
        int condition = compare(key, node.getKey());
        if (condition == 0) return false;
        else if (condition < 0) {
            if (node.left == null) {
                node.left = new Node(key, value, null, null);
                return true;
            }
            return addNode(node.left, key, value);
        } else {
            if (node.right == null) {
                node.right = new Node(key, value, null, null);
                return true;
            }
            return addNode(node.right, key, value);
        }
    }
}
