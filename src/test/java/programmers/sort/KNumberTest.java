package programmers.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class KNumberTest {

    private int[] array;
    private int[][] commands;

    @BeforeEach
    void setUp() {
        array = new int[]{1,5,2,6,3,7,4,};
        commands = new int[3][3];
        commands[0] = new int[]{2,5,3};
        commands[1] = new int[]{4,4,1};
        commands[2] = new int[]{1,7,3};
    }

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of((Object) new int[]{5,6,3})
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void KNumber알고리즘을_테스트한다(int[] expected) {
        assertThat(KNumber.test(array, commands)).isEqualTo(expected);
    }
}
