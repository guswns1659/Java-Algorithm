package programmers.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingTest {

    private Ranking ranking;

    @BeforeEach
    void setUp() {
        ranking = new Ranking();
    }

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void solution(int n, int[][] results, int expected) {
        assertThat(ranking.solution(n, results)).isEqualTo(expected);
    }
}
