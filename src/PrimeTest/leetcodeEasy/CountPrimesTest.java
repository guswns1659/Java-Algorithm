package leetcodeEasy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountPrimesTest {
    private CountPrimes countPrimes;

    @BeforeEach
    void setUp() {
        countPrimes = new CountPrimes();
    }

    @Test
    void countPrimes() {
        assertEquals(6, countPrimes.countPrimes(15));
    }
}
