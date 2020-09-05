package backjun.search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class N2512Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(Arrays.asList(120, 110, 140, 150), 485, 127),
                Arguments.of(Arrays.asList(100, 100, 100, 100), 485, 100)
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N2512알고리즘을_테스트한다(List<Integer> budgets, int totalBudgets, long expected) {
//        assertThat(N2512.test(budgets, totalBudgets)).isEqualTo(expected);
    }
}
