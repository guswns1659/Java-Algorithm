package doit.chap7.practice1;

public class IntSet {
    // 생성자
    private int max;
    private int size;
    private int[] set;

    public IntSet(int capacity) {
        max = capacity;
        size = 0;
        try {
            set = new int[max];
        } catch(OutOfMemoryError e) {
            max = 0;
        }
    }

    // indexOf, contains, add, remove, copyTo, copyFrom, equalTo, toString
    public int indexOf(int value) {
        for (int index = 0; index < size; index++) {
            if (set[index] == value) return index;
        }
        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public boolean add(int value) {
        if (size >= max || contains(value)) return false;
        set[size++] = value;
        return true;
    }

    public boolean remove(int value) {
        int index;
        if (size < 1 || (index = indexOf(value)) == -1) return false;
        set[index] = set[--size];
        return true;
    }

    public void copyTo(IntSet to) {
        int n = Math.min(to.size, size);
        for (int count = 0; count < n; count++) {
            to.set[count] = set[count];
        }
        to.size = n;
    }

    public void copyFrom(IntSet from) {
        int n = Math.min(from.size, size);
        for (int count = 0; count < n; count++) {
            set[count] = from.set[count];
        }
        size = n;
    }

    public boolean equalTo(IntSet another) {
        if (another.size != size) return false;
        for(int i = 0; i < size; i++) {
            int j = 0;
            for(; j < another.size; j++) {
                if (set[i] == another.set[j]) break;
            }
            if (j == another.size) return false;
        }
        return true;
    }
}
