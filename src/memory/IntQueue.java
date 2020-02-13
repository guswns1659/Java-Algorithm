package memory;

public class IntQueue {
    private int max;
    private int front;
    private int rear;
    private int size;
    private int[] queue;

    public static class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {

        }
    }

    public static class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {

        }
    }

    public IntQueue(int capacity) {
        front = rear = size = 0;
        max = capacity;
        try {
            queue = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enqueue(int value) {
        if (size >= max) throw new OverflowIntQueueException();
        queue[rear++] = value;
        size++;
        if (rear == max) rear = 0;
        return value;
    }

    public int dequeue() {
        if (size < 1) throw new EmptyIntQueueException();
        int value = queue[front++];
        size--;
        if (front == max) front = 0;
        return value;
    }

    public int peek() {
        if (size < 1) throw new EmptyIntQueueException();
        return queue[front];
    }

    public int indexOf(int value) {
        if (size < 1) throw new EmptyIntQueueException();
        for (int count = 0; count < size; count++) {
            int index = (count + front) % max;
            if (queue[index] == value) return index;
        }
        return -1;
    }

    public void clear() {
        size = front = rear = 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return max;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public boolean isFull() {
        return size >= max;
    }

    public void dump() {
        if (size < 1) System.out.println("큐가 비었습니다.");
        else {
            for (int count = 0; count < size; count++) {
                int index = (count + front) % max;
                System.out.print(queue[index] + " ");
            }
            System.out.println();
        }
    }

}
