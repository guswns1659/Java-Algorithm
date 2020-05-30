package topcoder;


import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ThePalindromeTest {

    private ThePalindrome thePalindrome;

    @Before
    public void setUp() {
        this.thePalindrome = new ThePalindrome();
    }

    @Test
    public void thePalindromeTest() {

        // given
        String[] examples = {"abab", "abacaba", "qwerty"};
        int[] expecteds = {5, 7, 11};

        // then
        for (int index = 0; index < examples.length; index++) {
            assertThat(this.thePalindrome.find(examples[index])).isEqualTo(expecteds[index]);
        }
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
