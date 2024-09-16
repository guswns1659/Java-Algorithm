package programmers.sort;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BiggestNumberTest {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(new int[]{6,10,2}, "6210"),
                Arguments.of(new int[]{3, 30, 34, 5, 9}, "9534330"),
                Arguments.of(new int[]{0,0,0}, "0"),
                Arguments.of(new int[]{0,1,0}, "100")
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void BiggestNumber알고리즘을_테스트한다(int[] numbers, String expected) {
        Assertions.assertThat(BiggestNumber.solution(numbers)).isEqualTo(expected);
    }
}
