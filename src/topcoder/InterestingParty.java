package topcoder;

import java.util.HashMap;
import java.util.Map;

public class InterestingParty {
    public static void main(String[] args) {
        String[] first = {"fishing", "gardening", "swimming", "fishing"};
        String[] second = {"hunting", "fishing", "fishing", "biting"};
        int answer = bestInvitation(first, second);
        System.out.println(answer);
    }

    public static int bestInvitation(String[] first, String[] second) {
        Map<String, Integer> hashMap = new HashMap<>();

        for (int index = 0; index < first.length; index++) {
            hashMap.put(first[index], 0);
            hashMap.put(second[index], 0);
        }

        for (int index = 0; index < first.length; index++) {
            hashMap.put(first[index], hashMap.get(first[index]) + 1);
            hashMap.put(second[index], hashMap.get(second[index]) + 1);
        }

        int answer = 0;
        for (Integer value : hashMap.values()) {
            answer = Math.max(answer, value);
        }

        return answer;
    }
}