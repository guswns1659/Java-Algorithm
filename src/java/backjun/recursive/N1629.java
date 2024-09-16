package backjun.recursive;

public class N1629 {
    public static void main(String[] args) {
        System.out.println(pow(10, 11, 12));
        System.out.println(pow(12, 1, 67));
        System.out.println(pow(12, 3, 67));
    }

    private static long pow(long a, long b, long m) {
        if (b == 1) {
            return a % m;
        }
        long val = pow(a, b/2, m);
        val = val * val % m;
        if (b % 2 ==0) {
            return val;
        }
        return val * a % m;
    }
}
