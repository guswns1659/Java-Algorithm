package barkingdog;

public class SumRecursion {

    public static void main(String[] args) {
        System.out.println(sumRecursion(5));
    }

    private static int sumRecursion(int num) {
        if (num <= 1) {
            return num;
        }
        return sumRecursion(num - 1) + num;
    }
}
