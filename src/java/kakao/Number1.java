package kakao;

public class Number1 {

    public static void main(String[] args) {
        System.out.println(solution("=.="));
    }

    private static String solution(String new_id) {

        // 1단계
        new_id = new_id.toLowerCase();
        // 2단계, -가 지워지면 안됨
        new_id = new_id.replaceAll("[^abcdefghijklmnopqrstuvwxyz0123456789\\-_.]", "").replace("@", "");

        // 3단계
        char[] chars = new_id.toCharArray();
        StringBuilder string = new StringBuilder();
        int dotCount = 0;
        for (int index = 0; index < chars.length; index++) {
            if (new_id.charAt(index) == '.') {
                if (dotCount == 0) {
                    dotCount++;
                    string.append(new_id.charAt(index));
                }
            } else {
                dotCount = 0;
                string.append(new_id.charAt(index));
            }
        }
        new_id = string.toString();

        // 4단계
        if (new_id.charAt(0) == '.') new_id = new_id.substring(1);
        if (new_id.length() >= 1) {
            if (new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length()-1);
        }

        // 5단계
        if (new_id.length() == 0) new_id = "a";

        //6
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length()-1);
        }

        //7
        char last;
        StringBuilder stringBuilder = new StringBuilder(new_id);
        if (new_id.length() <= 2) {
            last = new_id.charAt(new_id.length() - 1);
            while (new_id.length() < 3) {
                stringBuilder.append(last);
                new_id = stringBuilder.toString();
            }
        }

        return new_id;
    }
}
