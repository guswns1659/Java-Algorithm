package backjun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class N5397Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of("<<BP<A>>Cd-", "BAPC"),
                Arguments.of("ThIsIsS3Cr3t", "ThIsIsS3Cr3t"),
                Arguments.of("<<<<<<<>>ABC>>>>>", "ABC")
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N5397알고리즘_테스트를한다(String input, String expected) {
        assertThat(N5397.test(input)).isEqualTo(expected);
    }
}
