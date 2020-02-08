package doit.Ch2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Practice9Test {
    private Practice9 practice9;

    @BeforeEach
    void beforeEach() {
        practice9 = new Practice9();
    }

    @Test
    void testIsPrime() {
        assertEquals(14622, practice9.isPrime());
    }

}