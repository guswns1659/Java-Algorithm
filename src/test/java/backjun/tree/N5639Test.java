package backjun.tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class N5639Test {

//    @CsvSource({"50, 30, 24, 5, 28, 45, 98, 52, 60"})

    public static Stream<Arguments> setUpInputs() {
        return Stream.of(
                Arguments.of(50, Arrays.asList(30, 24, 5, 28, 45, 98, 52, 60))
        );
    }


    @ParameterizedTest
    @MethodSource("setUpInputs")
    void N5639을_테스트한다(int rootValue, List<Integer> nodes) throws Exception {
        // given
        TreeNode root = new TreeNode(rootValue);

        // when
        N5639.solution(root, nodes);
        // then
    }
}
