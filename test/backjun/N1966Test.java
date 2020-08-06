package backjun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class N1966Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(new int[]{1, 0}, new int[]{5}, 1),
                Arguments.of(new int[]{4, 2}, new int[]{1, 2, 3, 4}, 2),
                Arguments.of(new int[]{6, 0}, new int[]{1, 1, 9, 1, 1, 1}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N1966알고리즘을_테스트한다(int[] paperNumberAndFindingPaperIndex, int[] priorities, int expected) {
        assertThat(N1966.test(paperNumberAndFindingPaperIndex, priorities)).isEqualTo(expected);
    }
}
