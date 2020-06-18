package topcoder;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MazeMakerTest {

    private MazeMaker mazeMaker;

    public static Stream<Arguments> parameterProvider() {
        return Stream.of(
            Arguments.of(new String[] {"...", "...", "..."}, "0", "1", new int[] {1, 0, -1, 0}, new int[] {0, 1, 0, -1},
                3)
        );
    }

    @BeforeEach
    void setUp() {
        this.mazeMaker = new MazeMaker();
    }

    @DisplayName("MazeMaker의 LongestPath가 정상 동작하는지 테스트한다.")
    @MethodSource("parameterProvider")
    @ParameterizedTest
    void testLongestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol, int expected) {
        assertThat(this.mazeMaker.longestPath(maze, startRow, startCol, moveRow, moveCol)).isEqualTo(expected);
    }
}
