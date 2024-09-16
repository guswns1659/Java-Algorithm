package backjun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class N1874Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(8, new int[]{4, 3, 6, 8, 7, 5, 2, 1}),
                Arguments.of(5, new int[]{1, 2, 5, 3, 4})
        );
    }


//    @ParameterizedTest
//    @MethodSource("setUpInputs")
//    void N1874알고리즘_테스트를한다(int N, int[] sequences) {
//        System.out.println(N1874.test(N, sequences));
//    }
}
