//package backjun;
//
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.List;
//import java.util.stream.Stream;
//
//public class N10814Test {
//
//    private static Stream<Arguments> setUpInputs() {
//        return Stream.of(
//                Arguments.of(3, new String[]{"21 Junkyu", "21 Dohyun", "20 Sunyoung"})
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("setUpInputs")
//    void N10814알고리즘을_테스트한다(int testCase, String[] members) {
//        List<Member> result = N10814.test(testCase, members);
//        for (int index = 0; index < result.size(); index++) {
//            System.out.println(result.get(index).getAge() + " " + result.get(index).getName());
//        }
//    }
//}
