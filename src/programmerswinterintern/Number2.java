package programmerswinterintern;

import java.util.HashMap;
import java.util.Map;

public class Number2 {
    public static void main(String[] args) {
        Number2 number2 = new Number2();
//        System.out.println(number2.solution("qyyigoptvfb", "abcdefghijk", 3)); //hellopython
        System.out.println(number2.solution("a", "a", 3)); // a
        System.out.println(number2.solution("z", "a", 3)); // y
        System.out.println(number2.solution("ab", "ab", 3)); //
    }

    public String solution(String encrypted_text, String key, int rotation) {

        // map 초기화
        Map<Character, Integer> map = new HashMap<>();

        for (int num = 0; num < 26; num++) {
            char start = 'a';
            int index = 1;
            start += num;
            index += num;
            map.put(start, index);
        }

        String beforeAnswer = "";
        if (encrypted_text.length() != 1) {
            // rotation 계산
            if (rotation < 0) { // 오른쪽 3번
                rotation *= -1;
                for (int i = 0; i < rotation; i++) {
                    String a = String.valueOf(encrypted_text.charAt(encrypted_text.length() - 1));
                    encrypted_text = encrypted_text.substring(0, encrypted_text.length() - 1);
                    a += encrypted_text;
                    encrypted_text = a;
                    beforeAnswer = a;
                }
            } else if (rotation > 0) {
                for (int i = 0; i < rotation; i++) {
                    String a = String.valueOf(encrypted_text.charAt(0));
                    encrypted_text= encrypted_text.substring(1);
                    encrypted_text += a;
                    beforeAnswer = encrypted_text;
                }
            }
        } else {
            beforeAnswer = encrypted_text;
        }



        // 대응문자 계산
        StringBuilder answer = new StringBuilder();

        for (int index = 0; index < beforeAnswer.length(); index++) {
            // 대응문자
            char a = key.charAt(index);
            // 암호화 문자
            char b = beforeAnswer.charAt(index);
            int resultIndex = map.get(b) - map.get(a);
            if (resultIndex <= 0) {
                resultIndex = 26 + resultIndex;
            }
            // 위치에 맞는 알파벳 찾기
            for (char value : map.keySet()) {
                if (resultIndex == map.get(value)) {
                    answer.append(value);
                }
            }
        }

        return answer.toString();
    }
}
