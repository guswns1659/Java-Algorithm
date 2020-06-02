package topcoder;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FriendScoreTest {

    private FriendScore friendScore;

    private Logger logger = LoggerFactory.getLogger(FriendScoreTest.class);

    @Before
    public void setUp() {
        this.friendScore = new FriendScore();
    }

    @Test
    public void highestScoreTest() {

        // given
        List<String[]> friendsList = new ArrayList<>();
        String[] friends1 = {"NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN"};
        String[] friends2 = {"NNNNYNNNNN", "NNNNYNYYNN", "NNNYYYNNNN", "NNYNNNNNNN",
                "YYYNNNNNNY", "NNYNNNNNYN", "NYNNNNNYNN", "NYNNNNYNNN", "NNNNNYNNNN", "NNNNYNNNNN"};
        String[] friends3 = {"NNNNNNNNNNNNNNY", "NNNNNNNNNNNNNNN", "NNNNNNNYNNNNNNN", "NNNNNNNYNNNNNNY",
                "NNNNNNNNNNNNNNY", "NNNNNNNNYNNNNNN", "NNNNNNNNNNNNNNN", "NNYYNNNNNNNNNNN", "NNNNNYNNNNNYNNN",
                "NNNNNNNNNNNNNNY", "NNNNNNNNNNNNNNN", "NNNNNNNNYNNNNNN", "NNNNNNNNNNNNNNN", "NNNNNNNNNNNNNNN",
                "YNNYYNNNNYNNNNN"};

        friendsList.add(friends1);
        friendsList.add(friends2);
        friendsList.add(friends3);

        int[] expect = {4, 8, 6};

        long start = System.currentTimeMillis();

        // then
        for (int index = 0; index < friendsList.size(); index++) {
            assertThat(this.friendScore.highestScore(friendsList.get(index))).isEqualTo(expect[index]);
        }

        long end = System.currentTimeMillis();

        logger.info("elapsed : {}", end - start);
    }

    @Test
    public void countOfYTest() {

        // given
        String[] friends = {"NYNNN", "YNYNN", "NYNYN", "NNYNY", "NNNYN"};
        int[] expecteds = {1, 2, 2, 2, 1};

        // then
        for (int index = 0; index < friends.length; index++) {
            assertThat(this.friendScore.countOfY(friends[index])).isEqualTo(expecteds[index]);
        }
    }

}
