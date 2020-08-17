package backjun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class N1568Test {

    @ParameterizedTest
    @CsvSource({"14,7"})
    void N1568알고리즘_테스트한다(int number, int expected) {
        assertThat(N1568.test(number)).isEqualTo(expected);
    }
}
