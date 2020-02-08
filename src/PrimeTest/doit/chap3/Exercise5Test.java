package doit.chap3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise5Test {

    private Exercise5 exercise5;
    private int[] ints;

    @BeforeEach
    void setUp() {
        exercise5 = new Exercise5();
        ints = new int[] {1,3,5,7,7,7,7,8,8,9,9};
    }

    @Test
    void binarySearch() {
        assertEquals(2, exercise5.binarySearch(ints, ints.length, 5));
    }

    @Test
    void binSearchX() {
        assertEquals(3, exercise5.binSearchX(ints, ints.length, 7));
    }
}