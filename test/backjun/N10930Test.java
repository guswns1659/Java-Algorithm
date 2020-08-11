package backjun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.Assertions.assertThat;

public class N10930Test {

    @ParameterizedTest
    @CsvSource({"Baekjoon,9944e1862efbb2a4e2486392dc6701896416b251eccdecb8332deb7f4cf2a857"})
    void N10930알고리즘_테스트한다(String word, String expected) throws NoSuchAlgorithmException {
        assertThat(N10930.test(word)).isEqualTo(expected);
    }
}
