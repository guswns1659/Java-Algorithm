package topcoder;

public class ThePalindrome {

    public int find(String s) {
        if (isPalinDrome(s)) {
            return s.length();
        }

        String reversed = toReverse(s);

        StringBuilder toBuilder = new StringBuilder(s);

        int answer = s.length() * 2;

        for (int x = 0; x <= reversed.length(); x++) {
            for (int y = 1; y <= reversed.length(); y++) {
                if (x >= y) {
                    continue;
                }
                String appended = toBuilder.append(reversed, x, y).toString();
                if (isPalinDrome(appended)) {
                    answer = Math.min(answer, appended.length());
                }
                toBuilder = new StringBuilder(s);
            }
        }

        return answer;
    }

    protected String toReverse(String s) {
        StringBuilder toBuilder = new StringBuilder(s);
        return toBuilder.reverse().toString();
    }

    protected boolean isPalinDrome(String s) {
        StringBuilder convertBuilder = new StringBuilder(s);
        String reversed = convertBuilder.reverse().toString();
        return reversed.equals(s);
    }

    public int find2(String s) {

        for (int lengthOfS = s.length(); ; lengthOfS++) {

            boolean flag = true;

            for (int index = 0; index < s.length(); index++) {

                if ((lengthOfS - index - 1) < s.length() && s.charAt(index) != s.charAt(lengthOfS - index - 1)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return lengthOfS;
            }
        }
    }
}
