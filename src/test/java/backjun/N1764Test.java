package backjun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class N1764Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(new int[]{3, 4}, new ArrayList<>(Arrays.asList("a", "b", "c", "d", "c", "a", "e")), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N1765알고리즘을_테스트한다(int[] nAndM, List<String> names, int expected) {
        List<String> answers = N1764.test(nAndM, names);
        System.out.println(answers.size());
        answers.forEach(System.out::println);
    }
}
