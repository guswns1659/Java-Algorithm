package topcoder;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class CrazyBotTest {

    private CrazyBot crazyBot;

    private Logger logger = LoggerFactory.getLogger(CrazyBotTest.class);

    @Before
    public void setUp() {
        this.crazyBot = new CrazyBot();
    }

    @Test
    public void getProbabilityTest() {

        // given
        int[] n = {1, 2, 7, 14, 2};
        int[] easts = {25, 25, 50, 50, 10};
        int[] wests = {25, 25, 0, 50, 10};
        int[] souths = {25, 25, 0, 0, 50};
        int[] norths = {25, 25, 50, 0, 30};
        double[] expects = {1.0, 0.75, 1.0, 1.220703125E-4, 0.68};

        // when

        // then
        for (int index = 4; index < n.length; index++) {
            assertThat(this.crazyBot.getProbability(n[index], easts[index], wests[index], souths[index], norths[index]))
                    .isEqualTo(expects[index]);
        }
    }


}
