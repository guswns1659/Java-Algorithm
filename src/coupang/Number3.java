package coupang;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Number3 {
    public static void main(String[] args) {
        Number3 number3 = new Number3();
        System.out.println(number3.solution(3, new int[]{24,22,20,10,5,3,2,1})); // 3
        // 4
        System.out.println(number3.solution(2, new int[]{1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100}));
        System.out.println(number3.solution(2, new int[]{3,2,1}));
    }

    private int solution(int k, int[] score) {
        Map<Long, Set<Integer>> map = new HashMap<>();
        Map<Long, Integer> times = new HashMap<>();

        for (int i = 0; i < score.length-1; i++) {
            long a = score[i];
            long b = score[i+1];
            long s = a-b;
            if (!times.containsKey(s)) {
                times.put(s, 0);
            }
            times.put(s, times.get(s) + 1);
            if (!map.containsKey(s)) {
                map.put(s, new HashSet<>());
            }
            map.get(s).add(i);
            map.get(s).add(i+1);
        }

        Set<Integer> set = new HashSet<>();

        // k이상인 set을 꺼낸 뒤에 다른 set에 중복된 애들 지우고 score.length - set.size()
        for (long key : times.keySet()) {
            if (times.get(key) >= k) {
                set.addAll(map.get(key));
            }
        }

        return score.length - set.size();
    }
}
