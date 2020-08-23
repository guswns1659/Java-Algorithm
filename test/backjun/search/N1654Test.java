package backjun.search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class N1654Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(Arrays.asList(802, 743, 457, 539), 11, 200),
                Arguments.of(Arrays.asList(30,20,10), 6, 10)

        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N1654알고리즘을_테스트한다(List<Integer> cables, int need, long expected) {
        assertThat(N1654.test(cables, need)).isEqualTo(expected);
    }
}
