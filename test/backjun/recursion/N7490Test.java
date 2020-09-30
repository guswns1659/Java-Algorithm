package backjun.recursion;

import backjun.recursive.N7490;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class N7490Test {

    @ParameterizedTest
    @CsvSource({"1-23+4+5+6+7,0"})
    void N7490의_eval을_테스트한다(String string, int answer) {
        assertThat(N7490.eval(string)).isEqualTo(answer);
    }

    @ParameterizedTest
    @CsvSource({"1-23+4+5+6+7,11"})
    void N7490의_toCorrectExpression을_테스트한다(String string, int size) {
        List<String> expression = N7490.toCorrectExpression(string);
        System.out.println(expression);
        assertThat(expression.size()).isEqualTo(size);
    }
}
