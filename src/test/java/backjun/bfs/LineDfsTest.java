package backjun.bfs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineDfsTest {

    @ParameterizedTest
    @CsvSource({"11,1,6"})
    void 상반기_LINE인턴_알고리즘을_테스트한다(int conyLocation, int brownLocation, int result) throws Exception {
        assertThat(LineDfs.test(conyLocation, brownLocation)).isEqualTo(result);
    }
}
