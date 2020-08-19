package backjun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class N1668Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(Arrays.asList(3,4,6,4,3,7,2))
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N1668알고리즘을_테스트한다(List<Integer> numbers) {
        N1668.test(numbers).forEach(System.out::println);
    }
}
