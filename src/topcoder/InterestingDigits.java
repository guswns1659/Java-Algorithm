package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterestingDigits {
    public static void main(String[] args) {
        int base = 10;
        int[] answer = digits(base);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] digits(int base) {

        List<Integer> possibles = new ArrayList<>();

        for (int n = 2; n < base; n++) {
            boolean ok = true;

            for (int k1 = 0; k1 < base; k1++) {
                for (int k2 = 0; k2 < base; k2++) {
                    for (int k3 = 0; k3 < base; k3++) {
                        if (((k1 + k2 * base + k3 * base * base) % n == 0) && ((k1 + k2 + k3) % n != 0)) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) break;
                }
                if (!ok) break;
            }
            if (ok) possibles.add(n);
        }

        int[] answer = new int[possibles.size()];
        for (int index = 0; index < possibles.size(); index++) {
            answer[index] = possibles.get(index);
        }

        return answer;
    }
}
