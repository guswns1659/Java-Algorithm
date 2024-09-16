package programmersdevmaching;

import java.math.BigInteger;

public class Number1 {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;
        System.out.println(Number1.solution(w, h));
    }

    private static long solution(int w, int h) {
        int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        return ((long) w * (long) h) - (((long) w + (long) h) - gcd);
    }
}
