package doit.chap4.Exercise2;

import java.util.ArrayList;

public class Gstack<E> {
    private int max;
    private int pointer;
    private ArrayList<E> stack;

    public static class EmptyGStackException extends RuntimeException {
        public EmptyGStackException() {}
    }

    public static class OverflowGStackException extends RuntimeException{
        public OverflowGStackException() {}
    }

    public Gstack(int capacity) {
        pointer = 0;
        max = capacity;
        try {
            stack = new ArrayList<>();
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public E push (E value) {
        if (pointer >= max) throw new OverflowGStackException();
        stack.add(value);
        return value;
    }

    public E pop () {
        if (pointer < 1) throw new EmptyGStackException();
        return stack.get(pointer-1);
    }

}
