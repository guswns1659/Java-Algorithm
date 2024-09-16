package backjun.search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class N2110Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,8,4,9), 3, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N2110알고리즘을_테스트한다(List<Integer> homes, int router, int expected) {
        assertThat(N2110.test(homes, router)).isEqualTo(expected);
    }
}
