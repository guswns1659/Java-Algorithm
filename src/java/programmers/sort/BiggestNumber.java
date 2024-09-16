package programmers.sort;

import java.util.*;

public class BiggestNumber {

    public static String solution(int[] numbers) {
        StringBuilder maxNumber = new StringBuilder();
        List<String> digits = new ArrayList<>();

        for (int number : numbers) {
            digits.add(String.valueOf(number));
        }

        digits.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });

        if (digits.get(0).equals("0")) {
            return "0";
        }

        digits.forEach(maxNumber::append);

        return maxNumber.toString();
    }
}
