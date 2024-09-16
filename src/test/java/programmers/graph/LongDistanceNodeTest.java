package programmers.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LongDistanceNodeTest {

    private LongDistanceNode longDistanceNode;

    @BeforeEach
    void setUp() {
        longDistanceNode = new LongDistanceNode();
    }

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}, 3),
                Arguments.of(3, new int[][]{{1, 2}, {2, 3}}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void solution(int n, int[][] edge, int expected) {
        assertThat(longDistanceNode.solution(n, edge)).isEqualTo(expected);
    }
}
