package leetcodeEasy;

import java.util.ArrayList;
import java.util.List;

public class CountPrimes {
    private List<Integer> primes = new ArrayList<>();

    public int countPrimes(int n) {
        primes.clear();
        primes.add(2);
        primes.add(3);
        for (int each = 5; each < n; each += 2) {
            boolean flag = true;
            int i;
            for (i = 0; primes.get(i) * primes.get(i) <= each; i++) {
                if (each % primes.get(i) == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                primes.add(each);
            }
        }
        if (n == 0 || n == 1 || n == 2) return 0;
        if (n == 3) return 1;
        return primes.size();
    }
}
