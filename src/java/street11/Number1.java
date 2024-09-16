package street11;

public class Number1 {
    public static void main(String[] args) {
        Number1 number1 = new Number1();
//        System.out.println(number1.solution("aabab")); // 3
//        System.out.println(number1.solution("dog")); // 8
//        System.out.println(number1.solution("aababa")); // 2
//        System.out.println(number1.solution("baaaa")); // -1
        System.out.println(number1.solution("aa")); // 0
    }

    public int solution(String S) {
        int countA = 0;
        int inserted = 0;

        for (int index = 0; index < S.length(); index++) {
            char c = S.charAt(index);
            if (countA > 2) return -1;
            if (c == 'a') {
                countA++;
            } else {
                if (2 - countA > 0) {
                    inserted += 2 - countA;
                }
                countA = 0;
            }
        }

        if (countA == 0) {
            if (S.charAt(S.length() - 1) != 'a') {
                inserted += 2;
            }
        } else if (countA == 1) {
            inserted += 1;
        } else if (countA > 2) {
            return -1;
        }

        return inserted;
    }
}
