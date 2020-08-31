package programmers.hash;

public class PhoneBook {

    public static boolean solution(String[] phone_book) {
        for (int index1 = 0; index1 < phone_book.length; index1++) {
            for (int index2 = 0; index2 < phone_book.length; index2++) {
                String A = phone_book[index1];
                String B = phone_book[index2];

                if (index1 == index2 || index1 > index2) {
                    continue;
                }

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
