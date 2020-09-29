package street11;

import java.util.Arrays;

public class Number2 {
    public static void main(String[] args) {
        Number2 number2 = new Number2();
        System.out.println(Arrays.toString(number2.solution(new String[]{"zzzz", "ferz", "zdsr", "fgtd"}))); // [0, 1, 3]
        System.out.println(Arrays.toString(number2.solution(new String[]{"gr", "sd", "rg"}))); // []
        System.out.println(Arrays.toString(number2.solution(new String[]{"a", "b", "a"}))); // [0,2,0]
        System.out.println(Arrays.toString(number2.solution(new String[]{"bdafg", "ceagi"}))); // [0,1,2]
        System.out.println(Arrays.toString(number2.solution(new String[]{"a"}))); // []
    }

    public int[] solution(String[] S) {
        for (int i = 0; i < S.length; i++) {
            for (int j = 0; j < S.length; j++) {
                if (i >= j) continue;
                for (int index = 0; index < S[i].length(); index++) {
                    if (S[i].charAt(index) == S[j].charAt(index)) {
                        return new int[]{i,j,index};
                    }
                }
            }
        }
        return new int[]{};
    }
}
