package backjun.search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class N2805Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(Arrays.asList(20, 15, 10, 17), 7, 15)
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N2805알고리즘을_테스트한다(List<Integer> trees, int goal, int expected) {
        assertThat(N2805.test(trees, goal)).isEqualTo(expected);
    }
}
