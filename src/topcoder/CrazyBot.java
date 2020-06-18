package topcoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CrazyBot {

    private Logger logger = LoggerFactory.getLogger(CrazyBot.class);

    boolean[][] grid = new boolean[100][100];

    int[] vx = {1, -1, 0, 0};
    int[] vy = {0, 0, 1, -1};

    double[] prob = new double[4];

    public double getProbability(int n, int east, int west, int south, int north) {

        prob[0] = east / 100.0;
        prob[1] = west / 100.0;
        prob[2] = south / 100.0;
        prob[3] = north / 100.0;

        return dfs(50, 50, n);
    }

    private double dfs(int x, int y, int n) {

        if (grid[x][y]) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        grid[x][y] = true;

        double ret = 0;

        for (int countOfNode = 0; countOfNode < 4; countOfNode++) {

            ret += dfs(x + vx[countOfNode], y + vy[countOfNode], n - 1) * prob[countOfNode];

        }

        grid[x][y] = false;

        return ret;
    }

    protected int loggerTest(int number) {
        try {
            if (number < 5) {
                throw new IllegalStateException("wrong number");
            }
            return number;

        } catch (IllegalStateException e) {
            logger.error("error : ", e);
            return 0;
        }
    }
}
