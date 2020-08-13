package backjun;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class N4195Test {

    private static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(3, "Fred Barney", "Barney Betty", "Betty Wilma"),
                Arguments.of(3, "Fred Barney", "Betty Wilma", "Barney Betty")
        );
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N4195알고리즘을_테스트한다(int relationCount, String relation1, String relation2, String relation3) {
//        System.out.println(N4195.test(relationCount, relation1, relation2, relation3));
    }

    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N4195의_find를_테스트한다(int relationCount, String relation1, String relation2, String relation3) {
        String[] relation1Array = relation1.split(" ");
        String[] relation2Array = relation2.split(" ");
        String[] relation3Array = relation3.split(" ");

        initializeParentAndNumber(relation1Array);
        initializeParentAndNumber(relation2Array);
        initializeParentAndNumber(relation3Array);

        assertThat(N4195.find(relation1Array[0])).isEqualTo(relation1Array[0]);
    }

    private void initializeParentAndNumber(String[] relationArray) {
        if (!N4195.parent.containsKey(relationArray[0])) {
            N4195.parent.put(relationArray[0], relationArray[0]);
            N4195.networks.put(relationArray[0], 1);
        }
        if (!N4195.parent.containsKey(relationArray[1])) {
            N4195.parent.put(relationArray[1], relationArray[1]);
            N4195.networks.put(relationArray[1], 1);
        }
    }
}
