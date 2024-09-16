package naver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Number3 {

    public static void main(String[] args) {
        Number3 number3 = new Number3();
        System.out.println(number3.solution(50));
        System.out.println(number3.solution(5));
    }

    public long solution(int k) {

        Map<Integer, Integer> possible = new HashMap<>();


        int n = 1;
        while (2 * n <= k) {
            n++;
        }
        n--;

        List<Integer> numbers = new ArrayList<>();
        for (int i = 2; i <= k; i++) {
            numbers.add(i);
        }
        System.out.println(numbers);

        int digit = 1;

        while (digit <= n) {

        }


        return n;
    }
}
