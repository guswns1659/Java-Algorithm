package line;

import java.util.Arrays;

public class Number3 {

    public static void main(String[] args) {
        Number3 number3 = new Number3();
        System.out.println(Arrays.toString(number3.solution(10007)));
        System.out.println(Arrays.toString(number3.solution(9)));
        System.out.println(Arrays.toString(number3.solution(73425)));
    }

    public int[] solution(int n) {
        String word = String.valueOf(n);
        int count  = 0;

        while (word.length() != 1) {

            int index = word.length() / 2;
            while (word.charAt(index) == '0') {
                index++;
            }

            int head = Integer.parseInt(word.substring(0, index));
            int tail = Integer.parseInt(word.substring(index));
            word = String.valueOf(head + tail);
            count++;
        }
        return new int[]{count, Integer.parseInt(word)};
    }
}
