package memory;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    private Prime prime;

    @BeforeEach
    void setUp() {
        prime = new Prime();
    }

    @Test
    void testIsPrime() {
        assertEquals(3774, prime.isPrime());
    }

}