package programmers.hash;

import java.util.HashMap;

public class PhoneBook {

    public static boolean solution(String[] phone_book) {

        HashMap<String, Integer> map = new HashMap<>();
        int N = phone_book.length;

        for (String phoneNumber : phone_book) {
            map.put(phoneNumber, 1);
        }

        for (String A : phone_book) {
            for (String B : phone_book) {
                if (A.equals(B)) {
                    continue;
                }
                if (map.get(A) == N - 1) {
                    continue;
                }

                map.put(A, map.get(A) + 1);

                int ALength = A.length();
                int BLength = B.length();

                if (ALength >= BLength) {
                    if (B.equals(A.substring(0, BLength))) {
                        return false;
                    }
                } else {
                    if (A.equals(B.substring(0, ALength))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
