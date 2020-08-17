package backjun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class N1543Test {

    @ParameterizedTest
    @CsvSource(value = {"ababababa:aba:2", "a a a a a:a a:2"}, delimiter = ':')
    void N1543알고리즘을_테스트한다(String input, String word, int expected) {
        assertThat(N1543.test(input, word)).isEqualTo(expected);
    }
}
