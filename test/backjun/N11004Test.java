package backjun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class N11004Test {

    @ParameterizedTest
    @CsvSource({"5,2,4 1 2 3 5,2"})
    void N11004알고리즘을_테스트한다(int count, int k, String numbers, int expected) {
    }
}
