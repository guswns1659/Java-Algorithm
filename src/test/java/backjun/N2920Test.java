package backjun;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class N2920Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, "ascending"),
                Arguments.of(new int[]{8, 7, 6, 5}, "descending"),
                Arguments.of(new int[]{1, 4, 3, 2}, "mixed")
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void 알고리즘테스트한다(int[] inputs, String expected) {
        assertThat(N2920.test(inputs)).isEqualTo(expected);
    }
}
