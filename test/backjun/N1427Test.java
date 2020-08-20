package backjun;

import backjun.sorting.N1427;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class N1427Test {

    @ParameterizedTest
    @CsvSource({"2134, 4321"})
    void N1427알고리즘을_테스트한다(String number, String expected) {
        assertThat(N1427.test(number)).isEqualTo(expected);
    }
}
