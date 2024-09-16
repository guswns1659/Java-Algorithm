package backjun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class N1920Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(5, new int[]{4,1,5,2,3}, 5, new int[]{1,3,7,9,5})
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N1920알고리즘을_테스트한다(int N, int[] numbers, int M, int[] compares) {
        N1920.test(N, numbers, M, compares).forEach(System.out::println);
    }
}
