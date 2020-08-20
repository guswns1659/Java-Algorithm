package backjun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class N1181Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(Arrays.asList("abc", "a", "b", "c", "ab"))
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N1181알고리즘을_테스트한다(List<String> words) {
        N1181.test(words).forEach(System.out::println);
    }
}
