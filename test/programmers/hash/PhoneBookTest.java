package programmers.hash;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookTest {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of((Object) new String[]{"97674223", "1195524421", "119"}),
                Arguments.of((Object) new String[]{"12","123","1235","567","88"})
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void PhoneBook알고리즘을_테스트한다(String[] phoneBook) {
        assertThat(PhoneBook.solution(phoneBook)).isFalse();
    }
}
