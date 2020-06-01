package topcoder;


import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class ThePalindromeTest {

    private ThePalindrome thePalindrome;

    private final Logger logger = LoggerFactory.getLogger(ThePalindromeTest.class);

    @Before
    public void setUp() {
        this.thePalindrome = new ThePalindrome();
    }

    @Test
    public void findTest() {

        // given
        String[] examples = {"abcdwoeiruidsjfklsdfjksdlkfjklsd", "abacaba", "qwerty"};
        int[] expecteds = {(examples[0].length() * 2) - 1, 7, 11};

        long start = System.currentTimeMillis();

        // then
        for (int index = 0; index < examples.length; index++) {
            assertThat(this.thePalindrome.find(examples[index])).isEqualTo(expecteds[index]);
        }

        long end = System.currentTimeMillis();

        logger.info("lead time : {}", end - start);

    }

    @Test
    public void find2Test() {

        // given
        String[] examples = {"abcdwoeiruidsjfklsdfjksdlkfjklsd", "abacaba", "qwerty"};
        int[] expecteds = {(examples[0].length() * 2) - 1, 7, 11};

        long start = System.currentTimeMillis();

        // then
        for (int index = 0; index < examples.length; index++) {
            assertThat(this.thePalindrome.find2(examples[index])).isEqualTo(expecteds[index]);
        }

        long end = System.currentTimeMillis();

        logger.info("lead time : {}", end - start);
    }

    @Test
    public void isPalindromeTest() {

        // given
        String s = "abab";

        // then
        assertThat(this.thePalindrome.isPalinDrome(s)).isTrue();
    }

    @Test
    public void toReverse() {

        // given
        String s = "asdf";

        // then
        assertThat(this.thePalindrome.toReverse(s)).isEqualTo("fdsa");
    }

    @Test
    public void builderAppendTest() {

        //given
        String s = "asdf";
        StringBuilder builder = new StringBuilder("efgh");
        String expected = "efgha";

        // when
        String appended = builder.append(s, 0, 1).toString();

        // then
        assertThat(appended).isEqualTo(expected);
    }
}
