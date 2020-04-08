package leetcodeEasy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MajorityElementTest {
    private MajorityElement majorityElement;

    @BeforeEach
    void setUp() {
        majorityElement = new MajorityElement();
    }

    @Test
    void majorityElement() {
        int[] ints = {2, 1, 2, 4, 7};
        assertEquals(2, majorityElement.majorityElement(ints));
    }
}
