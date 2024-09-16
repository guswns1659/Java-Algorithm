package backjun.search;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class N10815Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(Arrays.asList(6,3,2,10,-10), Arrays.asList(10,9,-5,2,3,4,5,-10))
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N10815알고리즘을_테스트한다(List<Integer> cardNumbers, List<Integer> testCases) {
        System.out.println(N10815.test(cardNumbers, testCases));
    }
}
