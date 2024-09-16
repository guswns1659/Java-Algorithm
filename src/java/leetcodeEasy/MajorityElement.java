package leetcodeEasy;

import java.util.*;

public class MajorityElement {
    private HashMap<Integer, Integer> hashMap = new HashMap<>();

    public int majorityElement(int[] nums) {
        hashMap.clear();
        final int SIZE = nums.length;
        for (int each : nums) {
            if (!hashMap.containsKey(each)) {
                hashMap.put(each, 0);
            }
            hashMap.merge(each, 1, Integer::sum);
            if (hashMap.get(each) > (SIZE / 2)) return each;
        }
        return 0;
    }
}
