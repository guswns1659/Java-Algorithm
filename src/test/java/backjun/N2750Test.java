package backjun;

import backjun.sorting.N2750;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class N2750Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(new int[]{5,2,3,4,1})
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N2750알고리즘을_테스트한다(int[] numbers) {
        Arrays.stream(N2750.test(numbers)).forEach(System.out::println);
    }
}
