package doit.chap5.Practice1;

public class IntStack {
    private int max;
    private int pointer;
    private int[] stack;

    public static class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
        }
    }

    public static class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
        }
    }

    public IntStack(int capacity) {
        pointer = 0;
        max = capacity;
        try {
            stack = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int push(int value) {
        if (pointer >= max) throw new OverflowIntStackException();
        return stack[pointer++] = value;
    }

    public int pop() {
        if (pointer < 1) throw new EmptyIntStackException();
        return stack[--pointer];
    }

    public int peek() {
        if (pointer < 1) throw new EmptyIntStackException();
        return stack[pointer - 1];
    }

    public int indexOf(int value) {
        if (pointer < 1) throw new EmptyIntStackException();
        for (int index = pointer - 1; pointer >= 0; pointer--) {
            if (stack[index] == value) return index;
        }
        return -1;
    }

    public void clear() {
        pointer = 0;
    }

    public int size() {
        return pointer;
    }

    public int capacity() {
        return max;
    }

    public boolean isEmpty() {
        return pointer <= 0;
    }

    public boolean isFull() {
        return pointer >= max;
    }

    public void dump() {
        if (pointer < 1) System.out.println("스택이 비었습니다.");
        else {
            for (int index = 0; index < pointer; index++) {
                System.out.print(stack[index] + " ");
            }
            System.out.println();
        }
    }

}
