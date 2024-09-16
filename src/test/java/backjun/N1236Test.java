package backjun;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class N1236Test {

    private String[][] castle;

    @BeforeEach
    void setUp() {
        int N = 4;
        int M = 4;
        this.castle = new String[N][M];
        String status = "....";

        for (int row = 0; row < N; row++) {
            for (int column = 0; column < M; column++) {
                castle[row][column] = String.valueOf(status.charAt(column));
            }
        }
    }

    @ParameterizedTest
    @CsvSource("4")
    void N1236알고리즘을_테스트한다(int expected) {
        assertThat(N1235.test(this.castle)).isEqualTo(expected);
    }
}
