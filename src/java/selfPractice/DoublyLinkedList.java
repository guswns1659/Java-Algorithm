package selfPractice;

import java.util.Comparator;

public class DoublyLinkedList<E> {
    public class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        Node() {
            data = null;
            prev = next = this;
        }

        Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> current;

    public DoublyLinkedList() {
        head = current = new Node<E>();
    }

    public boolean isEmpty() {
        return head.next == head;
    }

    public E search(E data, Comparator<? super E> c) {
        Node<E> ptr = head.next;
        while (ptr != head) {
            if (c.compare(data, ptr.data) == 0) {
                current = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    public void dump() {
        Node<E> ptr = head.next;

        while (ptr != head) {
            System.out.println(ptr.data + " ");
            ptr = ptr.next;
        }
    }

    public void reverseDump() {
        Node<E> ptr = head.prev;

        while (ptr != head) {
            System.out.println(ptr.data + " ");
            ptr = ptr.prev;
        }
    }

    public void add(E data) {
        Node<E> node = new Node(data, current, current.next);
        current.next.prev = node;
        current.prev.next = node;
        current = node;
    }

    public void addFirst(E data) {
        current = head;
        add(data);
    }

    public void addLast(E data) {
        current = head.prev;
        add(data);
    }

    public void removeCurrent() {
        if (!isEmpty()) {
            current.next.prev = current.prev;
            current.prev.next = current.next;
            current = current.prev;
        }
        if (current == head) current = head.next;
    }

    public void remove(Node<E> p) {
        Node<E> ptr = head.next;

        while (ptr != head) {
            if (ptr == p) {
                current = ptr;
                removeCurrent();
                break;
            }
            ptr = ptr.next;
        }
    }

}
