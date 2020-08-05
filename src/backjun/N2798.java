package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input1 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] cards = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(test(input1, cards));
    }

    public static int test(int[] input1, int[] cards) {
        int goal = input1[1];
        int max = 0;

        for (int x = 0; x < cards.length - 1; x++) {
            for (int y = 1; y < cards.length - 1; y++) {
                if (x == y) {
                    continue;
                }
                for (int z = 2; z <cards.length - 1; z++) {
                    if (y == z) {
                        continue;
                    }
                    int possible = cards[x] + cards[y] + cards[z];
                    if (possible > max && possible <= goal) {
                        max = possible;
                    }
                }
            }
        }

        return max;
    }
}
