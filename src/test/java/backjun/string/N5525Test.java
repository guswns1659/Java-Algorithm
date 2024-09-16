package backjun.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class N5525Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(1, 13, "OOIOIOIOIIOII", 4)
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N5525알고리즘을_테스트한다(int level, int lengthOfString, String word, int expected) {
        assertThat(N5525.test(level, lengthOfString, word)).isEqualTo(expected);
    }


}
