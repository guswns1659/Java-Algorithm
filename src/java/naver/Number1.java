package naver;

public class Number1 {
    public static void main(String[] args) {
        Number1 number1 = new Number1();
        System.out.println(number1.solution(6, new int[]{5, 4, 7, 2, 0, 6}, new int[]{4, 6, 4, 9, 2, 3}));
        System.out.println(number1.solution(7, new int[]{6, 2, 1, 0, 2, 4, 3}, new int[]{3, 6, 6, 2, 3, 7, 6}));
    }

    public String solution(int n, int[] p, int[] c) {
        int fail = 0;
        int days = 0;
        int sales = 0;
        int money = 0;

        for (int i = 0; i < c.length; i++) {
            if (fail > 2) break;
            // 재고
            int a = p[i];
            // 일일 주문량
            int b = c[i];
            if (a >= b) {
                if (fail == 0) {
                    // 100
                    money = 100;
                } else if (fail == 1) {
                    // 50
                    money = 50;
                } else {
                    // 25
                    money = 25;
                }
                sales += b * money;
                if (i < c.length - 1) {
                    p[i + 1] += a - b;
                }
                fail = 0;
            } else {
                fail++;
                if (i < c.length - 1) {
                    p[i + 1] += a;
                }
            }
            days++;
        }

        double answer = Math.round((sales / (float) days) * 1000) / 1000.0;
        return answer + "0";
    }

}
