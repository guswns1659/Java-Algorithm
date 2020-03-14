package memory;

import java.util.Comparator;

public class DoublyLinkedList<E> {
    private Node<E> head;
    private Node<E> current;

    DoublyLinkedList() {
        head = current = new Node<E>(); // 같다의 의미가 아니라 대입한다는 의미.
    }

    public boolean isEmpty() {
        return head.next == head;
    }

    // 입력한 데이터 검색
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

    // 선택 노드 출력
    public void printCurrent() {
        if (isEmpty()) System.out.println("선택 노드가 없습니다.");
        else System.out.println(current.data);
    }

    // 모든 노드 출력
    public void dump() {
        Node<E> ptr = head.next;

        while (ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

    // 모든 노드를 거꾸로 출력
    public void reverseDump() {
        Node<E> ptr = head.prev;

        while (ptr != head) {
            System.out.println(ptr.data);
            ptr = ptr.prev;
        }
    }

    // 선택 노드를 하나 뒤쪽을 이동
    public boolean next() {
        if (isEmpty() || isTail()) {
            return false;
        }
        current = current.next;
        return true;
    }

    private boolean isTail() {
        return current.next == head;
    }


    // 선택 노드를 하나 앞으로 이동
    public boolean prev() {
        if (isEmpty() || isHead()) {
            return false;
        }
        current = current.prev;
        return true;
    }

    public boolean isHead() {
        return current.prev == head;
    }

    // 선택 노드의 바로 뒤에 노드를 삽입
    // current라는 포인터가 있기 때문에 삽입이 쉽다.
    public void add(E data) {
        Node<E> node = new Node<E>(data, current, current.next);
        current.next.prev = node;
        current.next = node;
        current = node;
    }

    // 머리에 노드 삽입
    public void addFirst(E data) {
        current = head;
        add(data);
    }

    // 꼬리에 노드 삽입
    public void addLast(E data) {
        current = head.prev;
        add(data);
    }

    // 선택 노드를 삭제
    public void removeCurrentNode() {
        if (!isEmpty()) {
            current.next.prev = current.prev;
            current.prev.next = current.next;
            current = current.prev;
        }
        if (current == head) current = head.next;
    }

    // 노드 p를 삭제
    public void remove(Node<E> p) {
        Node<E> ptr = head.next;

        while (ptr != head) {
            if (ptr == p) {
                current = ptr;
                removeCurrentNode();
                break;
            }
            ptr = ptr.next;
        }
    }

    // 머리 노드를 삭제
    public void removeFirst() {
        current = head.next;
        removeCurrentNode();
    }

    // 꼬리 노드를 삭제
    public void removeLast() {
        current = head.prev;
        removeCurrentNode();
    }

    // 모든 노드를 삭제
    public void clear() {
        while (!isEmpty()) {
            removeFirst();
        }
    }

    class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        public Node() {
            data = null;
            prev = next = this;
        }

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}
