package coupang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Number1 {
    public static void main(String[] args) {
        Number1 number1 = new Number1();
        System.out.println(Arrays.toString(number1.solution(10)));
        System.out.println(Arrays.toString(number1.solution(14)));
    }

    private int[] solution(int N) {

        int max = 0;
        List<Integer> nums = new ArrayList<>();
        for (int r = 2; r < 10; r++) {
            String s = Integer.toString(N, r);// 101
            String s1 = s.replaceAll("0", "");
            int num = 1;
            for (int i = 0; i < s1.length(); i++) {
                num *= s1.charAt(i) - '0';
            }
            if (num >= max) {
                max = num;
                nums.add(r);
            }
        }

        nums.sort(Collections.reverseOrder());
        return new int[]{nums.get(0), max};
    }
}
