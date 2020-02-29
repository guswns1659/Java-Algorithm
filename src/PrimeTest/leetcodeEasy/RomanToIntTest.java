package leetcodeEasy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanToIntTest {
    private RomanToInt romanToInt;

    @BeforeEach
    void setUp() {
        romanToInt = new RomanToInt();
    }

    @Test
    void romanToInt() {
        int expected = 4;
        String roman = "IV";
        assertEquals(expected, romanToInt.romanToInt(roman));
    }

    @Test
    void romanToInt2() {
        int expected = 1994;
        String roman = "MCMXCIV";
        assertEquals(expected, romanToInt.romanToInt(roman));
    }
}
