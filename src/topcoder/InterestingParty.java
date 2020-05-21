package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterestingParty {
    public static void main(String[] args) {
        String[] first = {"fishing", "gardening", "swimming", "fishing"};
        String[] second = {"hunting", "fishing", "fishing", "biting"};
        int answer = bestInvitation(first, second);
        System.out.println(answer);
    }

    public static int bestInvitation(String[] first, String[] second) {
        List<String> firstToList = new ArrayList(Arrays.asList(first));
        List<String> secondToList = new ArrayList(Arrays.asList(second));
        firstToList.addAll(secondToList);

        int answer = 1;
        for (int index = 0; index < firstToList.size(); index++) {
            String value = firstToList.get(index);
            int expect = 1;
            for (int index2 = 0; index2 < firstToList.size(); index2++) {
                if (index == index2) continue;
                else {
                    if (value.equals(firstToList.get(index2))) {
                        expect++;
                    }
                }
            }
            if (expect > answer) answer = expect;
        }
        return answer;

    }
}