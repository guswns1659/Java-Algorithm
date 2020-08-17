package backjun;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class N1302Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(Arrays.asList("a", "a", "b", "b", "kimtop"))
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N1032알고리즘_테스트(List<String> books) {
        N1302.test(books).forEach(System.out::println);
    }
}
