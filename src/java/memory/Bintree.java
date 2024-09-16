package memory;

import java.util.Comparator;

public class Bintree<K, V> {
    private Node<K, V> root;
    private Comparator<? super K> comparator;

    static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public void print() {
            System.out.println(value);
        }
    }

    public Bintree() {
        this.root = null;
    }

    public Bintree(Comparator<? super K> comparator) {
        this();
        this.comparator = comparator;
    }

    public int compare(K key1, K key2) {
        return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) : (comparator.compare(key1, key2));
    }

    public V search(K key) {
        Node<K, V> pointer = root;
        while (true) {
            int condition = compare(key, pointer.getKey());
            if (condition == 0) return pointer.getValue();
            else if (condition < 0) pointer = pointer.left;
            else pointer = pointer.right;
        }
    }

    public boolean add(K key, V value) {
        if (root == null) {
            Node<K, V> root = new Node<>(key, value, null, null);
            return true;
        }
        return addNode(root, key, value);
    }

    public boolean addNode(Node<K, V> node, K key, V value) {
        int condition = compare(key, node.getKey());
        if (condition == 0) return false;
        else if (condition < 1) {
            if (node.left == null) {
                node.left = new Node<>(key, value, null, null);
                return true;
            }
            return addNode(node.left, key, value);
        } else {
            if (node.right == null) {
                node.right = new Node<>(key, value, null, null);
                return true;
            }
            return addNode(node.right, key, value);
        }
    }

}
