package backjun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class N11650Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of((Object) new String[]{"3 4", "1 1", "1 -1", "2 2", "3 3"})
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N11650알고리즘을_테스트한다(String[] coordinates) {
        N11650.test(coordinates);
    }
}
