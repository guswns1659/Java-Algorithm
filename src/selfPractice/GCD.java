package selfPractice;

public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(22,18));
        System.out.println(gcd(20,5));
        System.out.println(gcd(19,17));
    }

    public static int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x%y);
    }
}
