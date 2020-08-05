package backjun;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class N2798Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(new int[]{5, 21}, new int[]{5, 6, 7, 8, 9}, 21),
                Arguments.of(new int[]{10, 500}, new int[]{93, 181, 245, 214, 315, 36, 185, 138, 216, 295}, 497)
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N2798알고리즘을_테스트한다(int[] input1, int[] card, int expected) {
        assertThat(N2798.test(input1, card)).isEqualTo(expected);
    }
}
