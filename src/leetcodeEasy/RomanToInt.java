package leetcodeEasy;

import java.util.HashMap;
import java.util.Stack;

public class RomanToInt {
    // I, V, X, L, C, D, M
    private static final HashMap<Character, Integer> hashMap = new HashMap<>();
    private static final Stack<Integer> stack = new Stack<>();

    public int romanToInt(String s) {
        initializeHashmap();
        char[] chars = s.toCharArray();
        int previous = 1000;
        int value = 0;
        for (char each : chars) {
            int current = hashMap.get(each);
            if (previous >= current) {
                stack.push(current);
                previous = current;
            } else {
                value = current - stack.pop();
                stack.push(value);
                previous = current;
            }
        }
        int result = stack.stream().mapToInt(v -> v).sum();
        return result;
    }

    private void initializeHashmap() {
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
    }
}
